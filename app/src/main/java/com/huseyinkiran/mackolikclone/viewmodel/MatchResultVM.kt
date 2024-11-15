package com.huseyinkiran.mackolikclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huseyinkiran.mackolikclone.model.ResultsResponse
import com.huseyinkiran.mackolikclone.service.ApiCallback
import com.huseyinkiran.mackolikclone.service.repository.LeagueRepository

class MatchResultVM(private val leagueKey: String) : ViewModel() {
    private val leagueRepository = LeagueRepository()
    val matchesLiveData = MutableLiveData<ResultsResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchMatches() {
        leagueRepository.fetchResults(leagueKey, object : ApiCallback<ResultsResponse> {
            override fun onSuccess(result: ResultsResponse) {
                matchesLiveData.postValue(result)
            }

            override fun onFailure(error: String) {
                errorLiveData.postValue(error)
            }

        })
    }
}

