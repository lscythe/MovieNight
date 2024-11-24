package dev.rendrap.app.movienight.core.designsystem.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.sqrt

enum class PatternStyle {
    DOTS,
    LINES,
    DIAGONAL_LINES,
    GRID,
    CHEVRON,
    CIRCLES
}

fun Modifier.patternBackground(
    patternStyle: PatternStyle = PatternStyle.DOTS,
    backgroundColor: Color = Color.Unspecified,
    patternColor: Color = Color.Unspecified,
    patternSize: Dp = 10.dp,
    patternStrokeWidth: Dp = 1.dp,
    patternSpacing: Dp = 20.dp
) = drawBehind {
    // Fill background first
    drawRect(backgroundColor)

    val patternSizePx = patternSize.toPx()
    val spacingPx = patternSpacing.toPx()
    val strokeWidthPx = patternStrokeWidth.toPx()

    when (patternStyle) {
        PatternStyle.DOTS -> {
            for (x in 0..size.width.toInt() step spacingPx.toInt()) {
                for (y in 0..size.height.toInt() step spacingPx.toInt()) {
                    drawCircle(
                        color = patternColor,
                        radius = patternSizePx / 2,
                        center = Offset(x.toFloat(), y.toFloat())
                    )
                }
            }
        }

        PatternStyle.LINES -> {
            val paint = Paint().apply {
                strokeWidth = strokeWidthPx
                color = patternColor
            }

            drawIntoCanvas { canvas ->
                for (y in 0..size.height.toInt() step spacingPx.toInt()) {
                    canvas.drawLine(
                        Offset(0f, y.toFloat()),
                        Offset(size.width, y.toFloat()),
                        paint
                    )
                }
            }
        }

        PatternStyle.DIAGONAL_LINES -> {
            val paint = Paint().apply {
                strokeWidth = strokeWidthPx
                color = patternColor
            }

            drawIntoCanvas { canvas ->
                val diagonal = sqrt(size.width * size.width + size.height * size.height)
                var x = -diagonal
                while (x < diagonal) {
                    canvas.drawLine(
                        Offset(x, 0f),
                        Offset(x + diagonal, diagonal),
                        paint
                    )
                    x += spacingPx
                }
            }
        }

        PatternStyle.GRID -> {
            val paint = Paint().apply {
                strokeWidth = strokeWidthPx
                color = patternColor
            }

            drawIntoCanvas { canvas ->
                // Vertical lines
                for (x in 0..size.width.toInt() step spacingPx.toInt()) {
                    canvas.drawLine(
                        Offset(x.toFloat(), 0f),
                        Offset(x.toFloat(), size.height),
                        paint
                    )
                }
                // Horizontal lines
                for (y in 0..size.height.toInt() step spacingPx.toInt()) {
                    canvas.drawLine(
                        Offset(0f, y.toFloat()),
                        Offset(size.width, y.toFloat()),
                        paint
                    )
                }
            }
        }

        PatternStyle.CHEVRON -> {
            val paint = Paint().apply {
                strokeWidth = strokeWidthPx
                color = patternColor
            }

            drawIntoCanvas { canvas ->
                var y = 0f
                while (y < size.height + spacingPx) {
                    var x = 0f
                    while (x < size.width + spacingPx) {
                        val path = Path().apply {
                            moveTo(x - patternSizePx, y + patternSizePx)
                            lineTo(x, y)
                            lineTo(x + patternSizePx, y + patternSizePx)
                        }
                        canvas.drawPath(path, paint)
                        x += spacingPx
                    }
                    y += spacingPx
                }
            }
        }

        PatternStyle.CIRCLES -> {
            val paint = Paint().apply {
                style = PaintingStyle.Stroke
                strokeWidth = strokeWidthPx
                color = patternColor
            }

            drawIntoCanvas { canvas ->
                for (x in 0..size.width.toInt() step spacingPx.toInt()) {
                    for (y in 0..size.height.toInt() step spacingPx.toInt()) {
                        canvas.drawCircle(
                            Offset(x.toFloat(), y.toFloat()),
                            patternSizePx,
                            paint
                        )
                    }
                }
            }
        }
    }
}

@ThemePreviews
@Composable
private fun PatternBackgroundPreview() {
    PreviewWrapper {
        Box(
            Modifier
                .fillMaxSize()
                .patternBackground(
                    PatternStyle.DOTS,
                    backgroundColor = Color.Transparent,
                    patternColor = MaterialTheme.colorScheme.primary,
                    patternSize = 14.dp,
                )
        )
    }
}