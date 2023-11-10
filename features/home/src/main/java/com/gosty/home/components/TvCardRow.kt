package com.gosty.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gosty.common.components.tv.TvCard
import com.gosty.model.tv.TvPreviewModel

@Composable
fun TvCardRow(
    list: List<TvPreviewModel>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(list.size) { index ->
            TvCard(
                tv = list[index],
                onClick = { /*TODO*/ }
            )
        }
    }
}