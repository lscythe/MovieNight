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

public val MVIcon.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.71f, 20.29f)
                lineTo(18.0f, 16.61f)
                arcTo(9.0f, 9.0f, 0.0f, true, false, 16.61f, 18.0f)
                lineToRelative(3.68f, 3.68f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.42f, 0.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, false, 21.71f, 20.29f)
                close()
                moveTo(11.0f, 18.0f)
                arcToRelative(7.0f, 7.0f, 0.0f, true, true, 7.0f, -7.0f)
                arcTo(7.0f, 7.0f, 0.0f, false, true, 11.0f, 18.0f)
                close()
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null
