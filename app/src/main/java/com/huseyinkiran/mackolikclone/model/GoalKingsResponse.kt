package com.huseyinkiran.mackolikclone.model

data class GoalKingsResponse(
    val success: Boolean,
    val result: List<GoalKing>
)

data class GoalKing(
    val goals: String? ="",
    val name: String? = ""
)

