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

public val MVIcon.Archive: ImageVector
    get() {
        if (_archive != null) {
            return _archive!!
        }
        _archive = Builder(name = "Archive", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0f, 13.0f)
                horizontalLineToRelative(4.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, -2.0f)
                horizontalLineTo(10.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, 2.0f)
                close()
                moveTo(19.0f, 3.0f)
                horizontalLineTo(5.0f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 4.0f, 8.82f)
                verticalLineTo(18.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 3.0f, 3.0f)
                horizontalLineTo(17.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 3.0f, -3.0f)
                verticalLineTo(8.82f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 19.0f, 3.0f)
                close()
                moveTo(18.0f, 18.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, 1.0f)
                horizontalLineTo(7.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, -1.0f)
                verticalLineTo(9.0f)
                horizontalLineTo(18.0f)
                close()
                moveTo(19.0f, 7.0f)
                horizontalLineTo(5.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 5.0f, 5.0f)
                horizontalLineTo(19.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 0.0f, 2.0f)
                close()
            }
        }
        .build()
        return _archive!!
    }

private var _archive: ImageVector? = null
