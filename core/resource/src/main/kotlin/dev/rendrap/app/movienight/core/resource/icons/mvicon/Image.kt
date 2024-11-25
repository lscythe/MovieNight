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

public val MVIcon.Image: ImageVector
    get() {
        if (_image != null) {
            return _image!!
        }
        _image = Builder(name = "Image", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(19.0f, 4.0f)
                lineTo(5.0f, 4.0f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 2.0f, 7.0f)
                lineTo(2.0f, 17.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 3.0f, 3.0f)
                lineTo(19.0f, 20.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 3.0f, -3.0f)
                lineTo(22.0f, 7.0f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 19.0f, 4.0f)
                close()
                moveTo(5.0f, 18.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, -1.0f)
                lineTo(4.0f, 14.58f)
                lineToRelative(3.3f, -3.29f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.4f, 0.0f)
                lineTo(15.41f, 18.0f)
                close()
                moveTo(20.0f, 17.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, 1.0f)
                horizontalLineToRelative(-0.77f)
                lineToRelative(-3.81f, -3.83f)
                lineToRelative(0.88f, -0.88f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.4f, 0.0f)
                lineTo(20.0f, 16.58f)
                close()
                moveTo(20.0f, 13.76f)
                lineTo(18.12f, 11.89f)
                arcToRelative(3.06f, 3.06f, 0.0f, false, false, -4.24f, 0.0f)
                lineToRelative(-0.88f, 0.88f)
                lineTo(10.12f, 9.89f)
                arcToRelative(3.06f, 3.06f, 0.0f, false, false, -4.24f, 0.0f)
                lineTo(4.0f, 11.76f)
                lineTo(4.0f, 7.0f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 5.0f, 6.0f)
                lineTo(19.0f, 6.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.0f, 1.0f)
                close()
            }
        }
        .build()
        return _image!!
    }

private var _image: ImageVector? = null
