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

public val MVIcon.ArrowLeft: ImageVector
    get() {
        if (_arrowLeft != null) {
            return _arrowLeft!!
        }
        _arrowLeft = Builder(name = "ArrowLeft", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(17.0f, 11.0f)
                horizontalLineTo(9.41f)
                lineToRelative(3.3f, -3.29f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, false, -1.42f, -1.42f)
                lineToRelative(-5.0f, 5.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.21f, 0.33f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, 0.76f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.21f, 0.33f)
                lineToRelative(5.0f, 5.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.42f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, -1.42f)
                lineTo(9.41f, 13.0f)
                horizontalLineTo(17.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, -2.0f)
                close()
            }
        }
        .build()
        return _arrowLeft!!
    }

private var _arrowLeft: ImageVector? = null
