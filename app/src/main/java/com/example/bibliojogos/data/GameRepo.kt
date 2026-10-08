package com.example.bibliojogos.data
import com.example.bibliojogos.data.GameDao
import kotlinx.coroutines.flow.Flow

class GameRepo(private val dao: GameDao) {
    val allGames: Flow<List<Game>> = dao.getAll()

    fun getGame(id: Int): Flow<Game?> = dao.getById(id)

    suspend fun insert(game: Game) = dao.insert(game)
    suspend fun update(game: Game) = dao.update(game)
    suspend fun delete(game: Game) = dao.delete(game)
}