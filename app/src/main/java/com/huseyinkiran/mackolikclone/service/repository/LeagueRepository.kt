package com.huseyinkiran.mackolikclone.service.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.huseyinkiran.mackolikclone.model.GoalKingsResponse
import com.huseyinkiran.mackolikclone.model.LeagueResponse
import com.huseyinkiran.mackolikclone.model.LeagueStandingsResponse
import com.huseyinkiran.mackolikclone.model.ResultsResponse
import com.huseyinkiran.mackolikclone.service.ApiCallback
import okhttp3.*
import java.io.IOException

class LeagueRepository {

    private val client = OkHttpClient()
    private val gson = Gson()
    private val API_KEY = "apikey 0F91lBq47bgnAmkxpOBDCG:1C6l7idZSqTMUHDr2k2aHY"
    // api istek aşımına uğrarsa (100 request / month) aşağıdaki linkten kendinize api key oluşturabilirsiniz
    // https://collectapi.com/tr/api/football/futbol-api?tab=pricing
    private val CONTENT_TYPE = "application-json"

    fun fetchLeagueList(callback: ApiCallback<LeagueResponse>) {
        val request = Request.Builder()
            .url("https://api.collectapi.com/football/leaguesList")
            .addHeader("content-type", CONTENT_TYPE)
            .addHeader("authorization", API_KEY)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure("Request failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!it.isSuccessful) {
                        callback.onFailure("Unexpected code $it")
                        return
                    }
                    val responseData = it.body?.string()
                    try {
                        val leagueListResponse =
                            gson.fromJson(responseData, LeagueResponse::class.java)
                        callback.onSuccess(leagueListResponse)
                        Log.d("League Repo", "onResponse: ${leagueListResponse.result}")
                    } catch (e: JsonSyntaxException) {
                        callback.onFailure("Data could not be processed. Please try again later.")
                        Log.e("LeagueRepo", "JSON parsing error: ${e.message}")
                    }
                }
            }
        })
    }

    fun fetchResults(league: String, callback: ApiCallback<ResultsResponse>) {
        val request = Request.Builder()
            .url("https://api.collectapi.com/football/results?data.league=$league")
            .addHeader("content-type", CONTENT_TYPE)
            .addHeader("authorization", API_KEY)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure("Request failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!it.isSuccessful) {
                        callback.onFailure("Unexpected code $it")
                        return
                    }
                    val responseData = it.body?.string()
                    try {
                        val resultsResponse =
                            gson.fromJson(responseData, ResultsResponse::class.java)
                        callback.onSuccess(resultsResponse)
                        Log.d("League Repo", "onResponse: ${resultsResponse.result}")
                    } catch (e: JsonSyntaxException) {
                        callback.onFailure("Data could not be processed. Please try again later.")
                        Log.e("LeagueRepo", "JSON parsing error: ${e.message}")
                    }
                }
            }
        })
    }

    fun fetchLeagueDetails(league: String, callback: ApiCallback<LeagueStandingsResponse>) {
        val request = Request.Builder()
            .url("https://api.collectapi.com/football/league?data.league=$league")
            .addHeader("content-type", CONTENT_TYPE)
            .addHeader("authorization", API_KEY)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure("Request failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!it.isSuccessful) {
                        callback.onFailure("Unexpected code $it")
                        return
                    }
                    val responseData = it.body?.string()
                    try {
                        val leagueDetailsResponse =
                            gson.fromJson(responseData, LeagueStandingsResponse::class.java)
                        callback.onSuccess(leagueDetailsResponse)
                        Log.d("League Repo", "onResponse: ${leagueDetailsResponse.result}")
                    } catch (e: JsonSyntaxException) {
                        callback.onFailure("Data could not be processed. Please try again later.")
                        Log.e("LeagueRepo", "JSON parsing error: ${e.message}")
                    }
                }
            }
        })
    }

    fun fetchGoalKings(league: String, callback: ApiCallback<GoalKingsResponse>) {
        val request = Request.Builder()
            .url("https://api.collectapi.com/football/goalKings?data.league=$league")
            .addHeader("content-type", CONTENT_TYPE)
            .addHeader("authorization", API_KEY)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure("Request failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!it.isSuccessful) {
                        callback.onFailure("Unexpected code $it")
                        return
                    }
                    val responseData = it.body?.string()
                    try {
                        val goalKingsResponse =
                            gson.fromJson(responseData, GoalKingsResponse::class.java)
                        callback.onSuccess(goalKingsResponse)
                        Log.d("League Repo", "onResponse: ${goalKingsResponse.result}")
                    } catch (e: JsonSyntaxException) {
                        callback.onFailure("Data could not be processed. Please try again later.")
                        Log.e("LeagueRepo", "JSON parsing error: ${e.message}")
                    }
                }
            }
        })
    }


}