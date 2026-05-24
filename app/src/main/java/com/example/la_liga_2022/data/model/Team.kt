package com.example.la_liga_2022.data.model

data class Team(
    val name: String,
    val logoUrl: String?,
    val rank: Int,
    val points: Int,
    val played: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsFor: Int,
    val goalsAgainst: Int
) {
    val goalDifference: Int
        get() = goalsFor - goalsAgainst
}
