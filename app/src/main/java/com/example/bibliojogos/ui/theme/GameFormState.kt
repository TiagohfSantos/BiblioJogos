package com.example.bibliojogos.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.bibliojogos.data.Game
import com.example.bibliojogos.data.GameStatus

data class GameFormState(
    val id: Int = 0,
    val name: String = "",
    val platform: String = "",
    val genre: String = "",
    val year: String = "",
    val status: GameStatus = GameStatus.POR_JOGAR,
    val isFavorite: Boolean = false,
    val cover: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val nameError: String? = null,
    val yearError: String? = null
) {
    val isEditing: Boolean get() = id != 0
}
fun Game.toFormState() = GameFormState(
    id = id, name = name, platform = platform, genre = genre,
    year = releaseYear.toString(), status = status, isFavorite = isFavorite,
    cover = cover, createdAt = createdAt
)

fun GameFormState.toGame() = Game(
    id = id, name = name.trim(), platform = platform.trim(), genre = genre.trim(),
    releaseYear = year.toIntOrNull() ?: 0, status = status, isFavorite = isFavorite,
    cover = cover, createdAt = createdAt
)