package com.huseyinkiran.mackolikclone.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huseyinkiran.mackolikclone.viewmodel.MatchResultVM

class MatchResultVMFactory(private val leagueKey: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchResultVM::class.java)) {
            return MatchResultVM(leagueKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

