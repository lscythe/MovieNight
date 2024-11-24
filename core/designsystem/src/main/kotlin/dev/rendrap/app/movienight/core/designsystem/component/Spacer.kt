package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen

@Composable
fun ColumnScope.SpaceExtraSmall() {
    Spacer(Modifier.height(MVDimen.ExtraSmall))
}

@Composable
fun ColumnScope.SpaceSmall() {
    Spacer(Modifier.height(MVDimen.Small))
}

@Composable
fun ColumnScope.SpaceMedium() {
    Spacer(Modifier.height(MVDimen.Medium))
}

@Composable
fun ColumnScope.SpaceRegular() {
    Spacer(Modifier.height(MVDimen.Regular))
}

@Composable
fun ColumnScope.SpaceLarge() {
    Spacer(Modifier.height(MVDimen.Large))
}

@Composable
fun ColumnScope.SpaceExtraLarge() {
    Spacer(Modifier.height(MVDimen.ExtraLarge))
}

@Composable
fun RowScope.SpaceExtraSmall() {
    Spacer(Modifier.width(MVDimen.ExtraSmall))
}

@Composable
fun RowScope.SpaceSmall() {
    Spacer(Modifier.width(MVDimen.Small))
}

@Composable
fun RowScope.SpaceMedium() {
    Spacer(Modifier.width(MVDimen.Medium))
}

@Composable
fun RowScope.SpaceRegular() {
    Spacer(Modifier.width(MVDimen.Regular))
}

@Composable
fun RowScope.SpaceLarge() {
    Spacer(Modifier.width(MVDimen.Large))
}

@Composable
fun RowScope.SpaceExtraLarge() {
    Spacer(Modifier.width(MVDimen.ExtraLarge))
}