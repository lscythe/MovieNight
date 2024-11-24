package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SingleBed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.common.extension.pairOf
import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO
import dev.rendrap.app.movienight.core.designsystem.extension.ifTrue
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.theme.MVOffset
import dev.rendrap.app.movienight.core.designsystem.theme.MVRadius
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MVTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = { MVTitleLarge(title) },
        navigationIcon = navigationIcon,
        actions = actions,
        modifier = modifier,
        windowInsets = windowInsets,
        expandedHeight = expandedHeight,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun MVNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = NavigationBarDefaults.containerColor,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier.brutalism(
            backgroundColor = containerColor,
            shadowColor = MaterialTheme.colorScheme.onBackground,
            shape = MVShape.ROUNDED,
            borderRadius = MVRadius.Medium,
            offset = MVOffset.Large
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .defaultMinSize(minHeight = NavigationBarContainerHeight)
                .selectableGroup(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
fun RowScope.MVNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val mvColor = LocalMVColor.current
    Box(
        modifier
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
            )
            .ifTrue(selected) {
                brutalism(
                    backgroundColor = mvColor.fifth,
                    shadowColor = MaterialTheme.colorScheme.onBackground,
                    shape = MVShape.ROUNDED,
                    borderRadius = MVRadius.Medium
                )
            }
            .height(NavigationBarContainerHeight)
            .weight(1f),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                icon,
                contentDescription = "NavBarItemIcon",
                tint = MaterialTheme.colorScheme.onBackground
            )
            AnimatedVisibility(
                visible = selected,
            ) {
                MVHeadlineMedium(
                    text = label,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize
                )
            }
        }
    }
}

@Composable
fun MVTabRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier.brutalism(
            backgroundColor = MaterialTheme.colorScheme.background,
            shadowColor = MaterialTheme.colorScheme.onBackground,
            shape = MVShape.ROUNDED,
            borderRadius = MVRadius.Medium,
            offset = MVOffset.Large
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = TabRowContainerHeight)
                .selectableGroup(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}

@Composable
fun RowScope.MVTab(
    selected: Boolean,
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val mvColor = LocalMVColor.current
    Box(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight()
            .ifTrue(selected) {
                brutalism(
                    backgroundColor = mvColor.sixth,
                    shadowColor = MaterialTheme.colorScheme.onBackground,
                    shape = MVShape.ROUNDED,
                    borderRadius = MVRadius.Medium
                )
            }
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.Tab,
            ),
        propagateMinConstraints = true,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            MVTitleMedium(
                label,
                textAlign = TextAlign.Center,
            )
        }
    }
}

private val NavigationBarContainerHeight = 80.dp
private val TabRowContainerHeight = 48.dp

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
private fun MVTopAppbarPreview() {
    PreviewWrapper {
        MVTopAppBar(
            title = "MV TopAppBar",
            navigationIcon = {
                MVIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) { }
            },
            actions = {
                MVIconButton(icon = Icons.Filled.Favorite) { }
                Spacer(Modifier.width(6.dp))
                MVIconButton(icon = Icons.Filled.Share) { }
            }
        )
    }
}

@ThemePreviews
@Composable
private fun MVNavigationBarPreview() {
    val navBarItems = listOf(
        pairOf(Icons.Filled.Language, "Discover"),
        pairOf(Icons.Filled.Search, "Search"),
        pairOf(Icons.Filled.Bookmarks, "Saved"),
        pairOf(Icons.Filled.Settings, "Settings")
    )
    var currentIndex by remember { mutableIntStateOf(ZERO) }
    PreviewWrapper {
        MVNavigationBar {
            navBarItems.forEachIndexed { index, pair ->
                MVNavigationBarItem(
                    selected = currentIndex == index,
                    onClick = { currentIndex = index },
                    icon = pair.first,
                    label = pair.second
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun MVNavigationItemPreview() {
    PreviewWrapper {
        Row {
            MVNavigationBarItem(
                selected = false,
                onClick = {},
                icon = Icons.Filled.SingleBed,
                label = "Discover"
            )
        }
    }
}

@ThemePreviews
@Composable
private fun MVTabRowPreview() {
    val tabs = listOf(
        "MV TabRow 1",
        "MV TabRow 2",
    )
    var currentIndex by remember { mutableIntStateOf(ZERO) }
    PreviewWrapper {
        MVTabRow {
            tabs.forEachIndexed { index, tab ->
                MVTab(currentIndex == index, label = tab) {
                    currentIndex = index
                }
            }
        }
    }
}