package com.example.la_liga_2022.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.la_liga_2022.data.model.Team
import com.example.la_liga_2022.data.repository.StandingsRepository
import kotlinx.coroutines.launch

data class StandingsUiState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String? = null
)

class StandingsViewModel : ViewModel() {

    private val repository = StandingsRepository()

    var state = androidx.compose.runtime.mutableStateOf(StandingsUiState())
        private set

    init {
        fetchStandings()
    }

    fun fetchStandings() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true, error = null)
            try {
                val teams = repository.getStandings()
                state.value = StandingsUiState(
                    isLoading = false,
                    teams = teams,
                    error = null
                )
            } catch (e: Exception) {
                state.value = StandingsUiState(
                    isLoading = false,
                    teams = emptyList(),
                    error = "Failed to load standings"
                )
            }
        }
    }
}
