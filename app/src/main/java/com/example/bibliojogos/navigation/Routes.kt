package com.example.bibliojogos.navigation

object Routes {
    const val LIST = "list"
    const val STATS = "stats"
    const val EDIT = "edit/{gameId}"

    fun edit(gameId: Int = -1) = "edit/$gameId"
}