package com.example.bibliojogos.ui.theme

import androidx.lifecycle.viewmodel.*
import com.example.bibliojogos.GameApplication
import androidx.lifecycle.ViewModelProvider

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            GameListViewModel(gameApplication().repositorio)
        }
    }
}

fun CreationExtras.gameApplication(): GameApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GameApplication