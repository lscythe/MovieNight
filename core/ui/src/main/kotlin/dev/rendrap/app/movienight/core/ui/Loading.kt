package dev.rendrap.app.movienight.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism

@Composable
fun MVLoadingOverlay() {
    val color = LocalMVColor.current
    Box(
        Modifier
            .fillMaxSize()
            .background(color.background), contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .size(60.dp)
                .brutalism(
                    shape = MVShape.FULL
                )
                .padding(MVDimen.ExtraSmall),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onBackground,
                strokeWidth = 4.dp,
                strokeCap = StrokeCap.Square
            )
        }
    }
}

@Composable
fun MVLoading() {
    Box(
        Modifier
            .size(60.dp)
            .brutalism(
                shape = MVShape.FULL
            )
            .padding(MVDimen.ExtraSmall),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.onBackground,
            strokeWidth = 4.dp,
            strokeCap = StrokeCap.Square
        )
    }
}

@ThemePreviews
@Composable
private fun MVLoadingPreview() {
    PreviewWrapper {
        MVLoadingOverlay()
    }
}