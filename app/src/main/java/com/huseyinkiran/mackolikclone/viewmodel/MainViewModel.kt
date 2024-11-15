package com.huseyinkiran.mackolikclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huseyinkiran.mackolikclone.model.LeagueResponse
import com.huseyinkiran.mackolikclone.service.ApiCallback
import com.huseyinkiran.mackolikclone.service.repository.LeagueRepository

class MainViewModel : ViewModel() {
    private val leagueRepository = LeagueRepository()
    val leaguesLiveData = MutableLiveData<LeagueResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchLeagues() {
        leagueRepository.fetchLeagueList(object : ApiCallback<LeagueResponse> {
            override fun onSuccess(result: LeagueResponse) {
                leaguesLiveData.postValue(result)
            }

            override fun onFailure(error: String) {
                errorLiveData.postValue(error)
            }
        })
    }

}

