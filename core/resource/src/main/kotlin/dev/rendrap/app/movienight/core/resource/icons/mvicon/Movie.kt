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

public val MVIcon.Movie: ImageVector
    get() {
        if (_movie != null) {
            return _movie!!
        }
        _movie = Builder(name = "Movie", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.0f, 2.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.0f, 1.0f)
                lineTo(20.0f, 5.0f)
                lineTo(18.0f, 5.0f)
                lineTo(18.0f, 3.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -2.0f, 0.0f)
                lineTo(16.0f, 4.0f)
                lineTo(8.0f, 4.0f)
                lineTo(8.0f, 3.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 6.0f, 3.0f)
                lineTo(6.0f, 5.0f)
                lineTo(4.0f, 5.0f)
                lineTo(4.0f, 3.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 2.0f, 3.0f)
                lineTo(2.0f, 21.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 2.0f, 0.0f)
                lineTo(4.0f, 19.0f)
                lineTo(6.0f, 19.0f)
                verticalLineToRelative(2.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 2.0f, 0.0f)
                lineTo(8.0f, 20.0f)
                horizontalLineToRelative(8.0f)
                verticalLineToRelative(1.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 2.0f, 0.0f)
                lineTo(18.0f, 19.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 2.0f, 0.0f)
                lineTo(22.0f, 3.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 21.0f, 2.0f)
                close()
                moveTo(6.0f, 17.0f)
                lineTo(4.0f, 17.0f)
                lineTo(4.0f, 15.0f)
                lineTo(6.0f, 15.0f)
                close()
                moveTo(6.0f, 13.0f)
                lineTo(4.0f, 13.0f)
                lineTo(4.0f, 11.0f)
                lineTo(6.0f, 11.0f)
                close()
                moveTo(6.0f, 9.0f)
                lineTo(4.0f, 9.0f)
                lineTo(4.0f, 7.0f)
                lineTo(6.0f, 7.0f)
                close()
                moveTo(16.0f, 18.0f)
                lineTo(8.0f, 18.0f)
                lineTo(8.0f, 13.0f)
                horizontalLineToRelative(8.0f)
                close()
                moveTo(16.0f, 11.0f)
                lineTo(8.0f, 11.0f)
                lineTo(8.0f, 6.0f)
                horizontalLineToRelative(8.0f)
                close()
                moveTo(20.0f, 17.0f)
                lineTo(18.0f, 17.0f)
                lineTo(18.0f, 15.0f)
                horizontalLineToRelative(2.0f)
                close()
                moveTo(20.0f, 13.0f)
                lineTo(18.0f, 13.0f)
                lineTo(18.0f, 11.0f)
                horizontalLineToRelative(2.0f)
                close()
                moveTo(20.0f, 9.0f)
                lineTo(18.0f, 9.0f)
                lineTo(18.0f, 7.0f)
                horizontalLineToRelative(2.0f)
                close()
            }
        }
        .build()
        return _movie!!
    }

private var _movie: ImageVector? = null
