package com.example.la_liga_2022.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.la_liga_2022.data.model.Team
import com.example.la_liga_2022.ui.theme.screen.StandingsScreen
import com.example.la_liga_2022.ui.theme.screen.TeamDetailScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    // ✅ TEMP HOLDER (SAFE, SIMPLE, NO ERRORS)
    val selectedTeamState = remember { mutableStateOf<Team?>(null) }

    NavHost(
        navController = navController,
        startDestination = "standings"
    ) {

        // ================= STANDINGS =================
        composable(route = "standings") {
            StandingsScreen(
                onTeamClick = { team ->
                    selectedTeamState.value = team
                    navController.navigate("team_detail")
                }
            )
        }

        // ================= TEAM DETAIL =================
        composable(route = "team_detail") {
            selectedTeamState.value?.let { team ->
                TeamDetailScreen(
                    team = team,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
