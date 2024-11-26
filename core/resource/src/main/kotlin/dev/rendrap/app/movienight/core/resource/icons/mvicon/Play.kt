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

public val MVIcon.Play: ImageVector
    get() {
        if (_play != null) {
            return _play!!
        }
        _play = Builder(name = "Play", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.54f, 9.0f)
                lineTo(8.88f, 3.46f)
                arcToRelative(3.42f, 3.42f, 0.0f, false, false, -5.13f, 3.0f)
                lineTo(3.75f, 17.58f)
                arcTo(3.42f, 3.42f, 0.0f, false, false, 7.17f, 21.0f)
                arcToRelative(3.43f, 3.43f, 0.0f, false, false, 1.71f, -0.46f)
                lineTo(18.54f, 15.0f)
                arcToRelative(3.42f, 3.42f, 0.0f, false, false, 0.0f, -5.92f)
                close()
                moveTo(17.54f, 13.19f)
                lineTo(7.88f, 18.81f)
                arcToRelative(1.44f, 1.44f, 0.0f, false, true, -1.42f, 0.0f)
                arcToRelative(1.42f, 1.42f, 0.0f, false, true, -0.71f, -1.23f)
                lineTo(5.75f, 6.42f)
                arcToRelative(1.42f, 1.42f, 0.0f, false, true, 0.71f, -1.23f)
                arcTo(1.51f, 1.51f, 0.0f, false, true, 7.17f, 5.0f)
                arcToRelative(1.54f, 1.54f, 0.0f, false, true, 0.71f, 0.19f)
                lineToRelative(9.66f, 5.58f)
                arcToRelative(1.42f, 1.42f, 0.0f, false, true, 0.0f, 2.46f)
                close()
            }
        }
        .build()
        return _play!!
    }

private var _play: ImageVector? = null
