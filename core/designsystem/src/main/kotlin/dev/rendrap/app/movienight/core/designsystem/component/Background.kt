package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.R
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews

@Composable
fun MVBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val color = LocalMVColor.current

    Box(modifier.background(color.background)) {
        Image(
            painter = painterResource(R.drawable.grunge_bg),
            contentDescription = "Grunge Background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            colorFilter = ColorFilter.tint(color.background, blendMode = BlendMode.Dst)
        )
        content()
    }
}

@ThemePreviews
@Composable
private fun MVBackgroundPreview() {
    PreviewWrapper {
        MVBackground(Modifier.size(500.dp)) {

        }
    }
}