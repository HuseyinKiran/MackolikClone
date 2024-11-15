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
import com.huseyinkiran.mackolikclone.adapter.PointRankAdapter
import com.huseyinkiran.mackolikclone.databinding.FragmentPointRankBinding
import com.huseyinkiran.mackolikclone.model.LeagueStanding
import com.huseyinkiran.mackolikclone.viewmodel.PointRankVM
import com.huseyinkiran.mackolikclone.viewmodel.factory.PointRankVMFactory

class PointRankFragment : Fragment() {

    private lateinit var binding: FragmentPointRankBinding
    private lateinit var rankVM: PointRankVM
    private var leagueKey: String? = null
    private var leagueName: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPointRankBinding.inflate(inflater, container, false)

        leagueKey = activity?.intent?.getStringExtra("league_key")
        leagueName = activity?.intent?.getStringExtra("league_name")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leagueKey?.let {
            val factory = PointRankVMFactory(it)
            rankVM = ViewModelProvider(this, factory)[PointRankVM::class.java]
            rankVM.fetchPointRank()
        }

        binding.txtLeagueName.text = leagueName
        binding.imgFlag.setImageResource(LeagueImageProvider.getImageResource(leagueKey!!))
        binding.progressBar.visibility = View.VISIBLE

        rankVM.pointRankLiveData.observe(viewLifecycleOwner, Observer { leagueStandingResponse ->
            if (leagueStandingResponse != null) {
                val teamList = leagueStandingResponse.result.map { team ->
                    LeagueStanding(
                        team.rank,
                        team.win,
                        team.draw,
                        team.lose,
                        team.play,
                        team.point,
                        team.goalFor,
                        team.goalAgainst,
                        team.goalDistance,
                        team.team
                    )
                }
                val adapter = PointRankAdapter(teamList)
                binding.leagueTeamsRv.layoutManager = LinearLayoutManager(requireContext())
                binding.leagueTeamsRv.adapter = adapter
                binding.progressBar.visibility = View.GONE
            }
        })
    }

}

