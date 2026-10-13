package com.example.bibliojogos.ui.theme

import androidx.lifecycle.viewmodel.*
import com.example.bibliojogos.GameApplication
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            GameListViewModel(gameApplication().repositorio)
        }
            initializer {
                GameEditViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    repository = gameApplication().repositorio
                )

        }
    }
}

fun CreationExtras.gameApplication(): GameApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GameApplication