package com.example.la_liga_2022.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.la_liga_2022.data.model.Team
import com.example.la_liga_2022.viewmodel.StandingsViewModel

@Composable
fun StandingsScreen(
    onTeamClick: (Team) -> Unit,
    viewModel: StandingsViewModel = viewModel()
) {
    val state by viewModel.state

    Column(modifier = Modifier.fillMaxSize()) {

        // 🟨 HEADER
        Text(
            text = "LA LIGA ",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFC107))
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            state.error != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(state.error!!, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { viewModel.fetchStandings() }) {
                            Text("Retry")
                        }
                    }
                }
            }

            else -> {
                LazyColumn {
                    items(state.teams) { team ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                .clickable { onTeamClick(team) },
                            colors = CardDefaults.cardColors(
                                containerColor = rankColor(team.rank)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                // 🖼️ TEAM LOGO
                                AsyncImage(
                                    model = team.logoUrl,
                                    contentDescription = team.name,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(end = 12.dp)
                                )

                                // 📄 TEAM NAME + RANK
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "${team.rank}. ${team.name}",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                    Text(
                                        text = "Played: ${team.played}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.DarkGray
                                    )
                                }

                                // ⭐ POINTS
                                Text(
                                    text = "${team.points} pts",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/* ================= RANK COLOR ================= */

private fun rankColor(rank: Int): Color {
    return when (rank) {
        1 -> Color(0xFFFFD700)         // Champion
        in 2..4 -> Color(0xFFBBDEFB)   // Champions League
        in 5..6 -> Color(0xFFC8E6C9)   // Europa
        in 18..20 -> Color(0xFFFFCDD2) // Relegation
        else -> Color.White
    }
}
