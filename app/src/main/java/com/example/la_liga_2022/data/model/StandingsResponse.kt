package com.example.la_liga_2022.data.model

data class StandingsResponse(
    val standings: List<Standing>
)

data class Standing(
    val table: List<TableItem>
)

data class TableItem(
    val position: Int,
    val points: Int,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val team: ApiTeam
)

data class ApiTeam(
    val name: String,
    val crest: String?   // ✅ MUST BE STRING
)
