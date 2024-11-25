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

public val MVIcon.SearchAlt: ImageVector
    get() {
        if (_searchAlt != null) {
            return _searchAlt!!
        }
        _searchAlt = Builder(name = "SearchAlt", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.07f, 16.83f)
                lineTo(19.0f, 14.71f)
                arcToRelative(3.08f, 3.08f, 0.0f, false, false, -3.4f, -0.57f)
                lineToRelative(-0.9f, -0.9f)
                arcToRelative(7.0f, 7.0f, 0.0f, true, false, -1.41f, 1.41f)
                lineToRelative(0.89f, 0.89f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 14.71f, 19.0f)
                lineToRelative(2.12f, 2.12f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 4.24f, 0.0f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 21.07f, 16.83f)
                close()
                moveTo(12.59f, 12.59f)
                arcToRelative(5.0f, 5.0f, 0.0f, true, true, 0.0f, -7.08f)
                arcTo(5.0f, 5.0f, 0.0f, false, true, 12.59f, 12.59f)
                close()
                moveTo(19.66f, 19.66f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.42f, 0.0f)
                lineToRelative(-2.12f, -2.12f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 0.0f, -1.42f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.42f, 0.0f)
                lineToRelative(2.12f, 2.12f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 19.66f, 19.66f)
                close()
            }
        }
        .build()
        return _searchAlt!!
    }

private var _searchAlt: ImageVector? = null
