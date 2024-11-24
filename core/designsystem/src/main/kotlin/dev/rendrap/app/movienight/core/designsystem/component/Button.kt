package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.theme.MVOffset
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews

@Composable
fun MVButton(
    label: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit
) {
    MVContainer(
        modifier.then(
            Modifier.defaultMinSize(
                ButtonDefaults.MinWidth,
                ButtonDefaults.MinHeight
            )
        ),
        backgroundColor = backgroundColor,
        onClick = onClick,
        offset = MVOffset.Large
    ) {
        MVLabelLarge(
            text = label,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun MVIconButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String = "Icon Button",
    shape: MVShape = MVShape.ROUNDED,
    tint: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit,
) {
    IconButtonContent(
        modifier = modifier,
        onClick = onClick,
        backgroundColor = backgroundColor,
        shape = shape
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = modifier.align(Alignment.Center),
            tint = tint,
        )
    }
}

@Composable
fun MVIconButton(
    bitmap: ImageBitmap,
    modifier: Modifier = Modifier,
    contentDescription: String = "Icon Button",
    shape: MVShape = MVShape.FULL,
    tint: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit,
) {
    IconButtonContent(
        modifier = modifier,
        onClick = onClick,
        backgroundColor = backgroundColor,
        shape = shape
    ) {
        Icon(
            bitmap = bitmap,
            contentDescription = contentDescription,
            modifier = modifier.align(Alignment.Center),
            tint = tint,
        )
    }
}

@Composable
fun MVIconButton(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String = "Icon Button",
    shape: MVShape = MVShape.FULL,
    tint: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit,
) {
    IconButtonContent(
        modifier = modifier,
        onClick = onClick,
        backgroundColor = backgroundColor,
        shape = shape
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier.align(Alignment.Center),
            tint = tint,
        )
    }
}

@Composable
private fun IconButtonContent(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    shape: MVShape,
    content: @Composable BoxScope.() -> Unit,
) {
    MVContainer(
        modifier = modifier.then(
            Modifier.size(40.dp)
        ),
        backgroundColor = backgroundColor,
        onClick = onClick,
        shape = shape,
        offset = MVOffset.Large
    ) {
        content()
    }
}

@ThemePreviews
@Composable
private fun MVButtonPreview() {
    PreviewWrapper {
        MVButton("Test") {}
    }
}

@ThemePreviews
@Composable
private fun MVIconButtonPreview() {
    PreviewWrapper {
        MVIconButton(Icons.AutoMirrored.Filled.ArrowBack) {}
    }
}