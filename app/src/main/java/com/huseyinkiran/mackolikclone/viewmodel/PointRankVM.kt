package com.huseyinkiran.mackolikclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huseyinkiran.mackolikclone.model.LeagueStandingsResponse
import com.huseyinkiran.mackolikclone.service.ApiCallback
import com.huseyinkiran.mackolikclone.service.repository.LeagueRepository

class PointRankVM(private val leagueKey: String) : ViewModel() {
    private val leagueRepository = LeagueRepository()
    val pointRankLiveData = MutableLiveData<LeagueStandingsResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchPointRank() {
        leagueRepository.fetchLeagueDetails(leagueKey, object : ApiCallback<LeagueStandingsResponse> {
            override fun onSuccess(result: LeagueStandingsResponse) {
                pointRankLiveData.postValue(result)
            }

            override fun onFailure(error: String) {
                errorLiveData.postValue(error)
            }

        })
    }

}

