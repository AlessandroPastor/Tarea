package com.example.tictactoe

import TicTacToeViewModel
import TicTacToeViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.tictactoe.data.GameDatabase
import com.example.tictactoe.repository.GameRepository
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos usando Room
        val db = Room.databaseBuilder(
            applicationContext,
            GameDatabase::class.java, "game_results_db"
        ).build()

        // Crear el repositorio
        val repository = GameRepository(db.gameDao())

        // Crear la ViewModelFactory
        val factory = TicTacToeViewModelFactory(repository)

        // Crear el ViewModel usando la factory
        val viewModel = ViewModelProvider(this, factory).get(TicTacToeViewModel::class.java)

        setContent {
            TicTacToeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TicTacToeScreen(viewModel = viewModel)
                }
            }
        }
    }
}
