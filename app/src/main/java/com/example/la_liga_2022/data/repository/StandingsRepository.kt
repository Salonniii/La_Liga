package com.example.la_liga_2022.data.repository

import com.example.la_liga_2022.data.model.Team
import com.example.la_liga_2022.data.network.ApiConstants
import com.example.la_liga_2022.data.network.RetrofitInstance

class StandingsRepository {

    suspend fun getStandings(): List<Team> {

        val response = RetrofitInstance.api.getLaLigaStandings(
            apiKey = ApiConstants.API_KEY
        )

        return response.standings.first().table.map { tableItem ->

            Team(
                name = tableItem.team.name,
                logoUrl = tableItem.team.crest,
                rank = tableItem.position,
                points = tableItem.points,
                played = tableItem.playedGames,
                wins = tableItem.won,
                draws = tableItem.draw,
                losses = tableItem.lost,
                goalsFor = tableItem.goalsFor,
                goalsAgainst = tableItem.goalsAgainst
            )
        }
    }
}
