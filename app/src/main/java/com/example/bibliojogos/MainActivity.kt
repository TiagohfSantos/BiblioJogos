package com.example.bibliojogos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliojogos.data.*
import com.example.bibliojogos.ui.theme.AppViewModelProvider
import com.example.bibliojogos.ui.theme.BiblioJogosTheme
import com.example.bibliojogos.ui.theme.GameListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiblioJogosTheme {
                val viewModel: GameListViewModel = viewModel(factory = AppViewModelProvider.Factory)
                val games by viewModel.games.collectAsStateWithLifecycle()
                Text("Jogos na base de dados: ${games.size}")
            }
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BiblioJogosTheme {
        Greeting("Android")
    }
}