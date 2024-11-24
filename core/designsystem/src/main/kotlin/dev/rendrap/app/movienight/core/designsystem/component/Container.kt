package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.extension.ifNotNull
import dev.rendrap.app.movienight.core.designsystem.theme.MVOffset
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism

@Composable
fun MVContainer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    shadowColor: Color = MaterialTheme.colorScheme.onBackground,
    borderWidth: Dp = 1.dp,
    offset: Offset = MVOffset.Medium,
    shape: MVShape = MVShape.ROUNDED,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.then(
            Modifier
                .ifNotNull(onClick) { clickable { it() } }
                .brutalism(
                    backgroundColor = backgroundColor,
                    shadowColor = shadowColor,
                    offset = offset,
                    borderWidth = borderWidth,
                    shape = shape
                )
        ),
    ) {
        content()
    }
}

@ThemePreviews
@Composable
private fun MVContainerPreview() {
    PreviewWrapper {
        MVContainer(Modifier.size(50.dp), onClick = {}) {

        }
    }
}