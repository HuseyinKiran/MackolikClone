package com.huseyinkiran.mackolikclone.model

data class LeagueResponse(
    val success: Boolean,
    val result: List<League>
)

data class League(
    val league: String,
    val key: String
)

