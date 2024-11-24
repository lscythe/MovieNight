package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.extension.ifTrue
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.theme.MVRadius
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism

@Composable
fun MVChip(
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val mvColor = LocalMVColor.current
    ChipContent(
        selected = selected,
        enabled = enabled,
        backgroundColor = mvColor.second,
        onClick = onClick,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = MVDimen.Medium, vertical = MVDimen.ExtraSmall)
        ) {
            MVLabelLarge(label)
        }
    }
}

@Composable
fun MVFilterChip(
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val mvColor = LocalMVColor.current
    val extraPadding by animateDpAsState(
        targetValue = if (selected) MVDimen.ExtraSmall else 0.dp,
        animationSpec = tween(durationMillis = 150),
        label = "padding"
    )
    ChipContent(
        selected = selected,
        enabled = enabled,
        backgroundColor = mvColor.fifth,
        onClick = onClick,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = MVDimen.ExtraSmall)
                .padding(start = MVDimen.Medium, end = MVDimen.Medium)
        ) {
            AnimatedVisibility(
                visible = selected,
                enter = fadeIn(tween(80)) + slideInHorizontally(tween(60)),
                exit = fadeOut(tween(80)) + slideOutHorizontally(tween(60)),
                modifier = Modifier.padding(end = extraPadding)
            ) {
                Row {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "CheckmarkIcon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            MVLabelLarge(label)
        }
    }
}

@Composable
fun MVInputChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val mvColor = LocalMVColor.current
    ChipContent(
        selected = true,
        enabled = enabled,
        backgroundColor = mvColor.sixth,
        onClick = onClick,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = MVDimen.ExtraSmall, horizontal = MVDimen.Medium)
        ) {
            MVLabelLarge(label)
            SpaceExtraSmall()
            Icon(
                Icons.Filled.Close,
                contentDescription = "CheckmarkIcon",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
private fun ChipContent(
    selected: Boolean,
    enabled: Boolean,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier
            .border(
                width = ChipBorderWidth,
                shape = RoundedCornerShape(MVRadius.Medium),
                color = MaterialTheme.colorScheme.onBackground
            )
            .clip(RoundedCornerShape(MVRadius.Medium))
            .ifTrue(selected) {
                brutalism(
                    backgroundColor = backgroundColor,
                    shadowColor = MaterialTheme.colorScheme.onBackground,
                    borderRadius = MVRadius.Medium,
                    shape = MVShape.ROUNDED
                )
            }
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Checkbox
            )
            .height(height = ChipHeight)
    ) {
        content()
    }
}

private val ChipHeight = 32.dp
private val ChipBorderWidth = 2.dp

@ThemePreviews
@Composable
private fun MVChipPreview() {
    PreviewWrapper {
        MVChip(
            selected = true,
            label = "MV Chip",
            onClick = {}
        )
    }
}

@ThemePreviews
@Composable
private fun MVFilterChipPreview() {
    var isSelected by remember { mutableStateOf(true) }
    PreviewWrapper {
        MVFilterChip(
            selected = isSelected,
            label = "MV Chip",
            onClick = { isSelected = !isSelected }
        )
    }
}

@ThemePreviews
@Composable
private fun MVInputChipPreview() {
    PreviewWrapper {
        MVInputChip(
            label = "MV Chip",
            onClick = {  }
        )
    }
}