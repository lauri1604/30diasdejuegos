package com.example.a30diasdejuegos
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30diasdejuegos.R
import com.example.a30diasdejuegos.data.Dataresource
import com.example.a30diasdejuegos.model.Game
import com.example.a30diasdejuegos.ui.theme._30DiasDeJuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val games = Dataresource().loadGames()
        setContent {
            _30DiasDeJuegosTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.home_title),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 36.sp
                        )
                        Text(
                            text = stringResource(R.string.home_subtitle),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 24.sp
                        )
                        GameList(
                            games = games,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GameDayCard(
    game: Game,
    modifier: Modifier = Modifier,
    onExpansionFrame: suspend () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    val descriptionVisibility = remember { MutableTransitionState(false) }

    LaunchedEffect(expanded) {
        descriptionVisibility.targetState = expanded
        if (expanded) {
            while (!descriptionVisibility.isIdle) {
                withFrameNanos { }
                onExpansionFrame()
            }
        }
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(game.imageResourceId),
                    contentDescription = stringResource(game.nameResourceId),
                    modifier = Modifier
                        .size(width = 132.dp, height = 144.dp)
                        .clip(RoundedCornerShape(14.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(14.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.game_day_format, game.dayNumber),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 29.sp
                    )
                    Text(
                        text = stringResource(game.nameResourceId),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        fontSize = 29.sp
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable { expanded = !expanded },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = if (expanded) "Ver menos" else "Ver más",
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 22.sp
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_expand_more),
                            contentDescription = if (expanded) "Ver menos" else "Ver más",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(34.dp)
                        )
                    }
                }
            }
            AnimatedVisibility(
                visibleState = descriptionVisibility,
                enter = expandVertically(tween(2500)) + fadeIn(tween(2500)),
                exit = shrinkVertically(tween(2500)) + fadeOut(tween(2500))
            ) {
                Text(
                    text = stringResource(game.descriptionResourceId),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 24.dp
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun GameList(games: List<Game>, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {
        itemsIndexed(games, key = { _, game -> game.dayNumber }) { index, game ->
            GameDayCard(
                game = game,
                onExpansionFrame = {
                    val item = listState.layoutInfo.visibleItemsInfo
                        .firstOrNull { it.index == index }
                    val overflow = item?.let {
                        it.offset + it.size - listState.layoutInfo.viewportEndOffset
                    } ?: 0
                    if (overflow > 0) {
                        listState.scrollBy(overflow.toFloat())
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DiasDeJuegosTheme {
        GameDayCard(
            game = Game(
                dayNumber = 1,
                nameResourceId = R.string.domino_title,
                descriptionResourceId = R.string.domino_description,
                imageResourceId = R.drawable.domino_pack
            )
        )
    }
}

@Preview(showBackground = true, heightDp = 900)
@Composable
fun GameListPreview() {
    _30DiasDeJuegosTheme {
        GameList(
            games = Dataresource().loadGames(),
            modifier = Modifier.fillMaxSize()
        )
    }
}
