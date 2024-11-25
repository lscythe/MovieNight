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

public val MVIcon.ChevronRight: ImageVector
    get() {
        if (_chevronRight != null) {
            return _chevronRight!!
        }
        _chevronRight = Builder(name = "ChevronRight", defaultWidth = 800.0.dp, defaultHeight =
                800.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.83f, 11.29f)
                lineTo(10.59f, 7.05f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.42f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, 1.41f)
                lineTo(12.71f, 12.0f)
                lineTo(9.17f, 15.54f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.0f, 1.41f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.71f, 0.29f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.71f, -0.29f)
                lineToRelative(4.24f, -4.24f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 14.83f, 11.29f)
                close()
            }
        }
        .build()
        return _chevronRight!!
    }

private var _chevronRight: ImageVector? = null
