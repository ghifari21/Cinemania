package com.gosty.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gosty.common.components.movie.MovieCard
import com.gosty.model.movie.MoviePreviewModel

@Composable
fun MovieCardRow(
    list: List<MoviePreviewModel>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(list.size) { index ->
            MovieCard(
                movie = list[index],
                onClick = { /*TODO*/ }
            )
        }
    }
}