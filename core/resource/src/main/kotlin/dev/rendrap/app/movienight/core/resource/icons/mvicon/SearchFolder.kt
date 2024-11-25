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

public val MVIcon.SearchFolder: ImageVector
    get() {
        if (_searchFolder != null) {
            return _searchFolder!!
        }
        _searchFolder = Builder(name = "SearchFolder", defaultWidth = 800.0.dp, defaultHeight =
                800.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(19.0f, 18.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 0.0f, -2.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.0f, -1.0f)
                lineTo(20.0f, 7.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.0f, -1.0f)
                lineTo(11.415f, 6.0f)
                lineToRelative(-0.471f, -1.334f)
                arcTo(1.001f, 1.001f, 0.0f, false, false, 10.0f, 4.0f)
                lineTo(5.0f, 4.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.0f, 1.0f)
                verticalLineToRelative(10.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.0f, 1.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 0.0f, 2.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, true, -3.0f, -3.0f)
                lineTo(2.0f, 5.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, true, 3.0f, -3.0f)
                horizontalLineToRelative(5.0f)
                curveToRelative(1.306f, 0.0f, 2.417f, 0.835f, 2.83f, 2.0f)
                lineTo(19.0f, 4.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, true, 3.0f, 3.0f)
                verticalLineToRelative(8.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, true, -3.0f, 3.0f)
                close()
                moveTo(13.99f, 17.904f)
                arcToRelative(5.002f, 5.002f, 0.0f, false, true, -6.293f, -7.707f)
                arcToRelative(5.0f, 5.0f, 0.0f, false, true, 7.707f, 6.293f)
                lineToRelative(2.9f, 2.9f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.415f, 1.413f)
                lineToRelative(-2.9f, -2.899f)
                close()
                moveTo(13.354f, 15.854f)
                arcTo(3.0f, 3.0f, 0.0f, true, false, 9.11f, 11.61f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 4.243f, 4.243f)
                close()
            }
        }
        .build()
        return _searchFolder!!
    }

private var _searchFolder: ImageVector? = null
