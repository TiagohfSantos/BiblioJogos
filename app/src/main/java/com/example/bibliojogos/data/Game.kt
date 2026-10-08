package com.example.bibliojogos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity ("games")
data class Game (
    @PrimaryKey(true) val id: Int = 0,
    val name: String,
    val platform: String,
    val genre: String,
    val releaseYear: Int,
    val status: GameStatus = GameStatus.POR_JOGAR,
    val isFavorite: Boolean = false,
    val cover: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
