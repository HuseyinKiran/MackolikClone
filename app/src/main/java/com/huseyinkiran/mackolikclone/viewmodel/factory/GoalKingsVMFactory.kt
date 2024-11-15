package com.huseyinkiran.mackolikclone.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huseyinkiran.mackolikclone.viewmodel.GoalKingsVM

class GoalKingsVMFactory(private val leagueKey: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoalKingsVM::class.java)) {
            return GoalKingsVM(leagueKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

