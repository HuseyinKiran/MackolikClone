package com.huseyinkiran.mackolikclone.service

interface ApiCallback<T> {
    fun onSuccess(result: T)
    fun onFailure(error: String)
}