package com.example.tictactoe.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameResultEntity::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}