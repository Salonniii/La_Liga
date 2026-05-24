package com.example.la_liga_2022.data.network

import com.example.la_liga_2022.data.model.StandingsResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballApi {

    @GET("competitions/PD/standings")
    suspend fun getLaLigaStandings(
        @Header("X-Auth-Token") apiKey: String
    ): StandingsResponse
}
