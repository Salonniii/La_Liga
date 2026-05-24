package com.example.la_liga_2022.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.la_liga_2022.data.model.Team

@Composable
fun TeamDetailScreen(
    team: Team,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(rankColor(team.rank))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 🔙 BACK
        Button(
            onClick = onBack,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🏟️ TEAM LOGO
        AsyncImage(
            model = team.logoUrl,
            contentDescription = team.name,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🏆 TEAM NAME
        Text(
            text = team.name,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 📊 STATS
        StatRow("Rank", team.rank)
        StatRow("Points", team.points)
        StatRow("Played", team.played)
        StatRow("Wins", team.wins)
        StatRow("Draws", team.draws)
        StatRow("Losses", team.losses)
        StatRow("Goals For", team.goalsFor)
        StatRow("Goals Against", team.goalsAgainst)
        StatRow(
            "Goal Difference",
            team.goalsFor - team.goalsAgainst
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🔁 RETRY BUTTON (SAFE – DOES NOT BREAK API)
        Button(
            onClick = onBack
        ) {
            Text("Retry")
        }
    }
}

@Composable
private fun StatRow(label: String, value: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge)
        Text(value.toString(), style = MaterialTheme.typography.bodyLarge)
    }
}

/* ================= RANK COLOR (SAME AS STANDINGS) ================= */

private fun rankColor(rank: Int): Color {
    return when (rank) {
        1 -> Color(0xFFFFD700)         // Yellow (Champion)
        in 2..4 -> Color(0xFFBBDEFB)   // Blue
        in 5..6 -> Color(0xFFFFE0B2)   // Orange
        7 -> Color(0xFFC8E6C9)         // Green
        else -> Color.White
    }
}
