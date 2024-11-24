package dev.rendrap.app.movienight.core.designsystem.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

enum class MVShape {
    FULL,
    NONE,
    ROUNDED
}

object MVShapes {
    val ExtraSmall: CornerBasedShape = ShapeDefaults.ExtraSmall
    val Small: CornerBasedShape = ShapeDefaults.Small
    val Medium: CornerBasedShape = ShapeDefaults.Medium
    val Large: CornerBasedShape = ShapeDefaults.Large
    val ExtraLarge: CornerBasedShape = ShapeDefaults.ExtraLarge
    val None: Shape = RectangleShape
    val Full: Shape = CircleShape
}