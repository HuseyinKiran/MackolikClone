package com.huseyinkiran.mackolikclone.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.huseyinkiran.mackolikclone.util.LeagueImageProvider
import com.huseyinkiran.mackolikclone.adapter.MatchResultAdapter
import com.huseyinkiran.mackolikclone.databinding.FragmentMatchesBinding
import com.huseyinkiran.mackolikclone.model.MatchResult
import com.huseyinkiran.mackolikclone.viewmodel.MatchResultVM
import com.huseyinkiran.mackolikclone.viewmodel.factory.MatchResultVMFactory

class MatchesFragment : Fragment() {

    private lateinit var binding: FragmentMatchesBinding
    private lateinit var matchResultVM: MatchResultVM
    private var leagueKey: String? = null
    private var leagueName: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchesBinding.inflate(inflater, container, false)

        leagueKey = activity?.intent?.getStringExtra("league_key")
        leagueName = activity?.intent?.getStringExtra("league_name")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leagueKey?.let {
            val factory = MatchResultVMFactory(it)
            matchResultVM = ViewModelProvider(this, factory)[MatchResultVM::class.java]
            matchResultVM.fetchMatches()
        }

        binding.txtLeagueName.text = leagueName
        binding.imgFlag.setImageResource(LeagueImageProvider.getImageResource(leagueKey!!))
        binding.progressBar.visibility = View.VISIBLE

        matchResultVM.matchesLiveData.observe(viewLifecycleOwner, Observer { resultsResponse ->
            if (resultsResponse != null) {
                val matchList = resultsResponse.result.map { matchResult ->
                    MatchResult(
                        matchResult.date,
                        matchResult.home,
                        matchResult.score,
                        matchResult.away
                    )
                }
                val adapter = MatchResultAdapter(matchList)
                binding.matchesRv.layoutManager = LinearLayoutManager(requireContext())
                binding.matchesRv.adapter = adapter
                binding.progressBar.visibility = View.GONE
            }
        })

    }

}

