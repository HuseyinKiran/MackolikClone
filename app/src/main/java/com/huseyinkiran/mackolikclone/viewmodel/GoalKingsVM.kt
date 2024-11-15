package com.huseyinkiran.mackolikclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huseyinkiran.mackolikclone.model.GoalKingsResponse
import com.huseyinkiran.mackolikclone.service.ApiCallback
import com.huseyinkiran.mackolikclone.service.repository.LeagueRepository

class GoalKingsVM(private val leagueKey: String) : ViewModel() {
    private val leagueRepository = LeagueRepository()
    val goalKingsLiveData = MutableLiveData<GoalKingsResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchGoalKings() {
        leagueRepository.fetchGoalKings(leagueKey, object : ApiCallback<GoalKingsResponse> {
            override fun onSuccess(result: GoalKingsResponse) {
                goalKingsLiveData.postValue(result)
            }

            override fun onFailure(error: String) {
                errorLiveData.postValue(error)
            }

        })
    }


}

