package com.huseyinkiran.mackolikclone.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huseyinkiran.mackolikclone.viewmodel.PointRankVM

class PointRankVMFactory(private val leagueKey: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PointRankVM::class.java)) {
            return PointRankVM(leagueKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

