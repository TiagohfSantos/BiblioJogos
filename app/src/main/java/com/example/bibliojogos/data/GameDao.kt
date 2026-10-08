package com.example.bibliojogos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games ORDER BY name ASC")
    fun getAll(): Flow<List<Game>>
    @Query("SELECT * FROM games WHERE id = :id")
    fun getById(id: Int): Flow<Game?>
    @Insert
    suspend fun insert(game: Game)
    @Update
    suspend fun update(game: Game)
    @Delete
    suspend fun delete(game: Game)
}