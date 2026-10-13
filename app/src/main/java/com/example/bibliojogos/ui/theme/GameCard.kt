package com.example.bibliojogos.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bibliojogos.data.Game
import com.example.bibliojogos.data.GameStatus

@Composable
fun GameCard(game: Game, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text(game.name, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "${game.platform} · ${game.genre} · ${game.releaseYear}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            StatusChip(game.status)
        }
    }
}

@Composable
fun StatusChip(status: GameStatus) {
    val color = when (status) {
        GameStatus.POR_JOGAR -> MaterialTheme.colorScheme.secondaryContainer
        GameStatus.A_JOGAR -> MaterialTheme.colorScheme.tertiaryContainer
        GameStatus.CONCLUIDO -> MaterialTheme.colorScheme.primaryContainer
    }
    Surface(color = color, shape = MaterialTheme.shapes.small) {
        Text(
            text = status.label,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}