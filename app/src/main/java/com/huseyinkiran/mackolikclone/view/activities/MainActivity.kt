package com.huseyinkiran.mackolikclone.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.huseyinkiran.mackolikclone.adapter.LeagueAdapter
import com.huseyinkiran.mackolikclone.databinding.ActivityMainBinding
import com.huseyinkiran.mackolikclone.util.FilterLeagues
import com.huseyinkiran.mackolikclone.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: LeagueAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        loadLeagues()

        binding.progressBar.visibility = View.VISIBLE

    }


    private fun loadLeagues() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.leaguesLiveData.observe(this) { response ->

            val showLeagues = response.result.filter { league ->
                FilterLeagues.showLeagues.contains(league.key)
            }

            adapter.updateList(showLeagues)
            binding.progressBar.visibility = View.GONE
        }

        viewModel.errorLiveData.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }

        viewModel.fetchLeagues()
    }

    private fun setupRecyclerView() {
        adapter = LeagueAdapter(emptyList()) { league ->
            val intent = Intent(this, LeagueDetailActivity::class.java)
            intent.putExtra("league_key", league.key)
            intent.putExtra("league_name", league.league)
            startActivity(intent)
        }
        binding.leaguesRv.adapter = adapter
        binding.leaguesRv.layoutManager = LinearLayoutManager(this)
    }

}

