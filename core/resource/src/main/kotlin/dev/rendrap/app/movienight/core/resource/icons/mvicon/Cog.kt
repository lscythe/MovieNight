package dev.rendrap.app.movienight.core.resource.icons.mvicon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.resource.icons.MVIcon

public val MVIcon.Cog: ImageVector
    get() {
        if (_cog != null) {
            return _cog!!
        }
        _cog = Builder(name = "Cog", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.32f, 9.55f)
                lineToRelative(-1.89f, -0.63f)
                lineToRelative(0.89f, -1.78f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 20.13f, 6.0f)
                lineTo(18.0f, 3.87f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.15f, -0.19f)
                lineToRelative(-1.78f, 0.89f)
                lineToRelative(-0.63f, -1.89f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 13.5f, 2.0f)
                horizontalLineToRelative(-3.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.95f, 0.68f)
                lineTo(8.92f, 4.57f)
                lineTo(7.14f, 3.68f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 6.0f, 3.87f)
                lineTo(3.87f, 6.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.19f, 1.15f)
                lineToRelative(0.89f, 1.78f)
                lineToRelative(-1.89f, 0.63f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 2.0f, 10.5f)
                verticalLineToRelative(3.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.68f, 0.95f)
                lineToRelative(1.89f, 0.63f)
                lineToRelative(-0.89f, 1.78f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 3.87f, 18.0f)
                lineTo(6.0f, 20.13f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.15f, 0.19f)
                lineToRelative(1.78f, -0.89f)
                lineToRelative(0.63f, 1.89f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.95f, 0.68f)
                horizontalLineToRelative(3.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.95f, -0.68f)
                lineToRelative(0.63f, -1.89f)
                lineToRelative(1.78f, 0.89f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 18.0f, 20.13f)
                lineTo(20.13f, 18.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.19f, -1.15f)
                lineToRelative(-0.89f, -1.78f)
                lineToRelative(1.89f, -0.63f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 22.0f, 13.5f)
                verticalLineToRelative(-3.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 21.32f, 9.55f)
                close()
                moveTo(20.0f, 12.78f)
                lineToRelative(-1.2f, 0.4f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 17.64f, 16.0f)
                lineToRelative(0.57f, 1.14f)
                lineToRelative(-1.1f, 1.1f)
                lineTo(16.0f, 17.64f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, false, -2.79f, 1.16f)
                lineToRelative(-0.4f, 1.2f)
                lineTo(11.22f, 20.0f)
                lineToRelative(-0.4f, -1.2f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 8.0f, 17.64f)
                lineToRelative(-1.14f, 0.57f)
                lineToRelative(-1.1f, -1.1f)
                lineTo(6.36f, 16.0f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 5.2f, 13.18f)
                lineTo(4.0f, 12.78f)
                lineTo(4.0f, 11.22f)
                lineToRelative(1.2f, -0.4f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 6.36f, 8.0f)
                lineTo(5.79f, 6.89f)
                lineToRelative(1.1f, -1.1f)
                lineTo(8.0f, 6.36f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 10.82f, 5.2f)
                lineToRelative(0.4f, -1.2f)
                horizontalLineToRelative(1.56f)
                lineToRelative(0.4f, 1.2f)
                arcTo(2.0f, 2.0f, 0.0f, false, false, 16.0f, 6.36f)
                lineToRelative(1.14f, -0.57f)
                lineToRelative(1.1f, 1.1f)
                lineTo(17.64f, 8.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, false, 1.16f, 2.79f)
                lineToRelative(1.2f, 0.4f)
                close()
                moveTo(12.0f, 8.0f)
                arcToRelative(4.0f, 4.0f, 0.0f, true, false, 4.0f, 4.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, false, 12.0f, 8.0f)
                close()
                moveTo(12.0f, 14.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, true, true, 2.0f, -2.0f)
                arcTo(2.0f, 2.0f, 0.0f, false, true, 12.0f, 14.0f)
                close()
            }
        }
        .build()
        return _cog!!
    }

private var _cog: ImageVector? = null
