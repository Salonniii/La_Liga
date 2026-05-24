package com.example.la_liga_2022.data.network

import com.example.la_liga_2022.data.model.Team
import retrofit2.http.GET

interface ApiService {

    @GET("standings")
    suspend fun getStandings(): List<Team>
}
