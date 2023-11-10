package com.gosty.common.components.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gosty.common.BuildConfig
//import com.gosty.cinemania.BuildConfig
import com.gosty.model.movie.MoviePreviewModel

@Composable
fun MovieCard(
    movie: MoviePreviewModel,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var imageSize by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.DarkGray),
        startY = imageSize.height.toFloat(),
        endY = imageSize.height.toFloat()
    )

    Card(
        modifier = modifier
            .width(120.dp)
            .height(150.dp)
            .background(Color.Transparent)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick(movie.id!!)
            },
        shape = RoundedCornerShape(size = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Transparent)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(BuildConfig.IMAGE_BASE_URL + movie.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(3f / 4f)
                    .clip(RoundedCornerShape(8.dp))
                    .onGloballyPositioned {
                        imageSize = it.size
                    }
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = gradient,
                        alpha = 0.3f
                    )
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = movie.voteAverage.toString().take(3),
                        color = Color.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Text(
                    text = movie.title ?: "Title",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = rememberLazyGridState(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            items(movies.size) { index ->
                MovieCard(
                    movie = movies[index],
                    onClick = {

                    }
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}

val movies = listOf(
    MoviePreviewModel(
        id = 1,
        title = "That time i reincarnated as a slime",
        posterPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        backdropPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        overview = "Overview",
        releaseDate = "2021-01-01",
        voteAverage = 5.0,
        voteCount = 100,
        isAdult = false,
        popularity = 100.0,
        originalLanguage = "en",
        originalTitle = "Original title",
        isVideo = false
    ),
    MoviePreviewModel(
        id = 2,
        title = "That time i reincarnated as a slime",
        posterPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        backdropPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        overview = "Overview",
        releaseDate = "2021-01-01",
        voteAverage = 5.0,
        voteCount = 100,
        isAdult = false,
        popularity = 100.0,
        originalLanguage = "en",
        originalTitle = "Original title",
        isVideo = false
    ),
    MoviePreviewModel(
        id = 3,
        title = "That time i reincarnated as a slime",
        posterPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        backdropPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        overview = "Overview",
        releaseDate = "2021-01-01",
        voteAverage = 5.0,
        voteCount = 100,
        isAdult = false,
        popularity = 100.0,
        originalLanguage = "en",
        originalTitle = "Original title",
        isVideo = false
    ),
    MoviePreviewModel(
        id = 4,
        title = "That time i reincarnated as a slime",
        posterPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        backdropPath = "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
        overview = "Overview",
        releaseDate = "2021-01-01",
        voteAverage = 5.0,
        voteCount = 100,
        isAdult = false,
        popularity = 100.0,
        originalLanguage = "en",
        originalTitle = "Original title",
        isVideo = false
    )
)