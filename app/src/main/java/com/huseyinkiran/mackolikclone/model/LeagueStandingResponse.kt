package com.huseyinkiran.mackolikclone.model

import com.google.gson.annotations.SerializedName

data class LeagueStandingsResponse(
    val success: Boolean,
    val result: List<LeagueStanding>
)

data class LeagueStanding(
    val rank: Int? = 0,
    val win: Int? = 0,
    val draw: Int? = 0,
    val lose: Int? = 0,
    val play: Int? = 0,
    val point: Int? = 0,
    @SerializedName("goalfor")
    val goalFor: Int? = 0,
    @SerializedName("goalagainst")
    val goalAgainst: Int? = 0,
    @SerializedName("goaldistance")
    val goalDistance: Int? = 0,
    val team: String? = ""
)

