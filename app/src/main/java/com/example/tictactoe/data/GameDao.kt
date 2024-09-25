package com.example.tictactoe.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {
    @Insert
    suspend fun insertGameResult(result: GameResultEntity)

    @Query("SELECT * FROM game_results")
    suspend fun getAllGameResults(): List<GameResultEntity>
}