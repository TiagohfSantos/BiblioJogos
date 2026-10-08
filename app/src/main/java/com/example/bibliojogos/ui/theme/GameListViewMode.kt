package com.example.bibliojogos.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bibliojogos.data.Game
import com.example.bibliojogos.data.GameRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class GameListViewModel(private val repository: GameRepo) : ViewModel() {

    val games: StateFlow<List<Game>> = repository.allGames
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
}