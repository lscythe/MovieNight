package dev.rendrap.app.movienight.core.designsystem.utils

import android.graphics.RectF
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO_FLOAT
import dev.rendrap.app.movienight.core.designsystem.theme.MVOffset
import dev.rendrap.app.movienight.core.designsystem.theme.MVRadius
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape

fun Modifier.brutalism(
    backgroundColor: Color = Color.Unspecified,
    shadowColor: Color = Color.Unspecified,
    offset: Offset = MVOffset.Medium,
    borderWidth: Dp = 2.dp,
    borderRadius: Dp = MVRadius.ExtraSmall,
    shape: MVShape = MVShape.NONE
): Modifier {
    val shapes = when (shape) {
        MVShape.FULL -> CircleShape
        MVShape.NONE -> RectangleShape
        MVShape.ROUNDED -> RoundedCornerShape(borderRadius)
    }

    return drawBehind {
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = shadowColor.toArgb()

            val leftPixel = offset.x
            val topPixel = offset.y
            val rightPixel = this.size.width + offset.x
            val bottomPixel = this.size.height + offset.y

            val shadowRect = RectF(
                leftPixel,
                topPixel,
                rightPixel,
                bottomPixel
            )
            when (shape) {
                MVShape.FULL -> {
                    val radius = minOf(size.width, size.height) / 2f
                    it.nativeCanvas.drawCircle(
                        size.width / 2f + offset.x,
                        size.height / 2f + offset.y,
                        radius,
                        frameworkPaint
                    )
                }
                MVShape.NONE -> {
                    it.nativeCanvas.drawRoundRect(
                        shadowRect,
                        ZERO_FLOAT,
                        ZERO_FLOAT,
                        frameworkPaint
                    )
                }
                MVShape.ROUNDED -> {
                    val cornerRadius = borderRadius.toPx()
                    it.nativeCanvas.drawRoundRect(
                        shadowRect,
                        cornerRadius,
                        cornerRadius,
                        frameworkPaint
                    )
                }
            }
        }
    }
        .border(
            width = borderWidth,
            color = shadowColor,
            shape = shapes
        )
        .padding(1.dp)
        .background(
            color = backgroundColor,
            shape = shapes
        )
        .clip(shapes)
}

@ThemePreviews
@Composable
fun NeoBrutalismFullPreview() {
    PreviewWrapper {
        Surface(
            Modifier.size(32.dp).brutalism(
                backgroundColor = MaterialTheme.colorScheme.background,
                shadowColor = MaterialTheme.colorScheme.onBackground,
                shape = MVShape.FULL
            )
        ) {

        }
    }
}

@ThemePreviews
@Composable
fun NeoBrutalismNonePreview() {
    PreviewWrapper {
        Surface(
            Modifier.size(32.dp).brutalism(
                backgroundColor = MaterialTheme.colorScheme.background,
                shadowColor = MaterialTheme.colorScheme.onBackground,
                shape = MVShape.NONE
            )
        ) {

        }
    }
}

@ThemePreviews
@Composable
fun NeoBrutalismRoundedPreview() {
    PreviewWrapper {
        Surface(
            Modifier.size(32.dp).brutalism(
                backgroundColor = MaterialTheme.colorScheme.background,
                shadowColor = MaterialTheme.colorScheme.onBackground,
                shape = MVShape.ROUNDED
            )
        ) {

        }
    }
}
