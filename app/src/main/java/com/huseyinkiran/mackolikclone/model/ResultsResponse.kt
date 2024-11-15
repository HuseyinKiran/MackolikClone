package com.huseyinkiran.mackolikclone.model

import com.google.gson.annotations.SerializedName

data class ResultsResponse(
    val success: Boolean,
    val result: List<MatchResult>
)

data class MatchResult(
    val date: String? = "N/A",
    val home: String? = "",
    @SerializedName("skor")
    val score: String? = "BV",
    val away: String? = ""
)

