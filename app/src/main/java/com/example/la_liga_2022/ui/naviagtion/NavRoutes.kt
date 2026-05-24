package com.example.la_liga_2022.ui.navigation

sealed class NavRoutes(val route: String) {
    object Standings : NavRoutes("standings")
    object TeamDetail : NavRoutes("team_detail")
}
