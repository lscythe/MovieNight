package dev.rendrap.app.movienight.feature.home.screen.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.rendrap.app.movienight.core.common.utils.Constants.ONE
import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO
import dev.rendrap.app.movienight.core.designsystem.component.MVTab
import dev.rendrap.app.movienight.core.designsystem.component.MVTabRow
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.resource.LocalResourceStrings
import dev.rendrap.app.movienight.feature.home.screen.discover.content.DiscoverMovieContent
import dev.rendrap.app.movienight.feature.home.screen.discover.content.DiscoverTVContent
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.MovieSortBy
import dev.rendrap.app.movienight.model.TVSortBy
import kotlinx.coroutines.launch

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier,
    onShowMoreMovieClick: (type: MovieSortBy) -> Unit,
    onShowMoreTVClick: (type: TVSortBy) -> Unit,
    onMediaClick: (id: Long, type: MediaType) -> Unit,
) {
    val strings = LocalResourceStrings.current
    val tabs = listOf(
        strings.movies,
        strings.tvSeries
    )
    val coroutineScope = rememberCoroutineScope()

    var currentTabIndex by remember { mutableIntStateOf(ZERO) }
    val pagerState = rememberPagerState { tabs.size }
    val color = LocalMVColor.current

    Column(
        modifier
            .background(color.background)
            .systemBarsPadding()) {
        MVTabRow(Modifier.padding(horizontal = MVDimen.Regular)) {
            tabs.forEachIndexed { index, tab ->
                MVTab(
                    selected = currentTabIndex == index,
                    label = tab,
                    onClick = {
                        currentTabIndex = index
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    }
                )
            }
        }
        HorizontalPager(state = pagerState, userScrollEnabled = false) { page ->
            when (page) {
                ZERO -> DiscoverMovieContent(
                    onShowMoreClick = onShowMoreMovieClick,
                    onMovieClick = { onMediaClick(it, MediaType.MOVIES) }
                )

                ONE -> DiscoverTVContent(
                    onShowMoreClick = onShowMoreTVClick,
                    onTVClick = { onMediaClick(it, MediaType.TV_SERIES) }
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun DiscoverScreenPreview() {
    PreviewWrapper {
        DiscoverScreen(Modifier, {}, {}, { _, _ -> })
    }
}