package com.huseyinkiran.mackolikclone.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.huseyinkiran.mackolikclone.util.LeagueImageProvider
import com.huseyinkiran.mackolikclone.adapter.GoalKingsAdapter
import com.huseyinkiran.mackolikclone.databinding.FragmentGoalKingsBinding
import com.huseyinkiran.mackolikclone.model.GoalKing
import com.huseyinkiran.mackolikclone.viewmodel.GoalKingsVM
import com.huseyinkiran.mackolikclone.viewmodel.factory.GoalKingsVMFactory

class GoalKingsFragment : Fragment() {

    private lateinit var binding: FragmentGoalKingsBinding
    private lateinit var goalKingVM: GoalKingsVM
    private var leagueKey: String? = null
    private var leagueName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalKingsBinding.inflate(inflater, container, false)

        leagueKey = activity?.intent?.getStringExtra("league_key")
        leagueName = activity?.intent?.getStringExtra("league_name")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leagueKey?.let {
            val factory = GoalKingsVMFactory(it)
            goalKingVM = ViewModelProvider(this, factory)[GoalKingsVM::class.java]
            goalKingVM.fetchGoalKings()
        }

        binding.txtLeagueName.text = leagueName
        binding.imgFlag.setImageResource(LeagueImageProvider.getImageResource(leagueKey!!))
        binding.progressBar.visibility = View.VISIBLE

        goalKingVM.goalKingsLiveData.observe(viewLifecycleOwner, Observer { goalKingsResponse ->
            if (goalKingsResponse != null) {
                val playerList = goalKingsResponse.result.map { player ->
                    GoalKing(player.goals, player.name)
                }
                val adapter = GoalKingsAdapter(playerList)
                binding.goalKingsRv.layoutManager = LinearLayoutManager(requireContext())
                binding.goalKingsRv.adapter = adapter
                binding.progressBar.visibility = View.GONE
            }
        })
    }
}


