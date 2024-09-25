package com.example.tictactoe.repository

import com.example.tictactoe.data.GameDao
import com.example.tictactoe.data.GameResultEntity

class GameRepository(private val gameDao: GameDao) {
    suspend fun insertGameResult(result: GameResultEntity) {
        gameDao.insertGameResult(result)
    }

    suspend fun getAllGameResults(): List<GameResultEntity> {
        return gameDao.getAllGameResults()
    }
}