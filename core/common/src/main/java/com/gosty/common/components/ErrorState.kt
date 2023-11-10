package com.gosty.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gosty.common.R
import timber.log.Timber

@Composable
fun ErrorState(
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.Asset(
            assetName = "errorwarning.json"
        )
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        Text(
            text = stringResource(
                id = R.string.error_state_message
            ),
            color = Color.Black,
            style = MaterialTheme.typography.labelLarge
        )

        Button(
            onClick = { onRefresh() },
            modifier = Modifier
                .width(150.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.refresh),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ErrorStatePreview() {
    ErrorState(
        onRefresh = {
            Timber.tag("ErrorStatePreview").d("onRefresh")
        }
    )
}