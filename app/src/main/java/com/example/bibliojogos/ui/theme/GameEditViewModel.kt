package com.example.bibliojogos.ui.theme

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bibliojogos.data.Game
import com.example.bibliojogos.data.GameRepo
import com.example.bibliojogos.data.GameStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Year


class GameEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: GameRepo
) : ViewModel() {

    private val gameId: Int = savedStateHandle["gameId"] ?: -1

    private val _uiState = MutableStateFlow(GameFormState())
    val uiState: StateFlow<GameFormState> = _uiState.asStateFlow()

    init {
        if (gameId != -1) {
            viewModelScope.launch {
                val game = repository.getGame(gameId).filterNotNull().first()
                _uiState.value = game.toFormState()
            }
        }
    }

    fun onNameChange(value: String) = _uiState.update { it.copy(name = value, nameError = null) }
    fun onPlatformChange(value: String) = _uiState.update { it.copy(platform = value) }
    fun onGenreChange(value: String) = _uiState.update { it.copy(genre = value) }
    fun onStatusChange(value: GameStatus) = _uiState.update { it.copy(status = value) }

    fun onYearChange(value: String) {
        if (value.length <= 4 && value.all { it.isDigit() }) {
            _uiState.update { it.copy(year = value, yearError = null) }
        }
    }

    private fun validate(): Boolean {
        val state = _uiState.value
        val maxYear = 2026 + 1
        val year = state.year.toIntOrNull()
        val nameError = if (state.name.isBlank()) "O nome é obrigatório" else null
        val yearError = if (year == null || year !in 1958..maxYear) "Indica um ano entre 1950 e $maxYear" else null
        _uiState.update { it.copy(nameError = nameError, yearError = yearError) }
        return nameError == null && yearError == null
    }

    fun save(onSaved: () -> Unit) {
        if (!validate()) return
        viewModelScope.launch {
            val game = _uiState.value.toGame()
            if (_uiState.value.isEditing) repository.update(game) else repository.insert(game)
            onSaved()
        }
    }

    fun delete(onDeleted: () -> Unit) {
        viewModelScope.launch {
            repository.delete(_uiState.value.toGame())
            onDeleted()
        }
    }
}