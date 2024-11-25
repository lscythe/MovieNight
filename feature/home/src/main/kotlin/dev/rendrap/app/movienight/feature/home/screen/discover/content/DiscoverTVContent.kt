package dev.rendrap.app.movienight.feature.home.screen.discover.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.rendrap.app.movienight.core.designsystem.component.NavigationBarContainerHeight
import dev.rendrap.app.movienight.core.designsystem.component.SpaceMedium
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.resource.LocalResourceStrings
import dev.rendrap.app.movienight.core.ui.MVLoadingOverlay
import dev.rendrap.app.movienight.feature.home.component.MediaItemWithCategory
import dev.rendrap.app.movienight.feature.home.component.TrendingItem
import dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel.DiscoverTVUIState
import dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel.DiscoverTVViewModel
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.TVSortBy
import saschpe.log4k.Log

@Composable
internal fun DiscoverTVContent(
    modifier: Modifier = Modifier,
    viewModel: DiscoverTVViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val trending by viewModel.trending.collectAsStateWithLifecycle()
    val topRated by viewModel.topRated.collectAsStateWithLifecycle()
    val airingToday by viewModel.airingToday.collectAsStateWithLifecycle()
    val onTheAir by viewModel.onTheAir.collectAsStateWithLifecycle()
    val popular by viewModel.popular.collectAsStateWithLifecycle()

    val tvSeries = mapOf(
        TVSortBy.AIRING_TODAY to airingToday,
        TVSortBy.POPULAR to popular,
        TVSortBy.TOP_RATED to topRated,
        TVSortBy.ON_THE_AIR to onTheAir,
        TVSortBy.TRENDING to trending,
    )

    Log.debug { tvSeries.toString() }

    DiscoverTVContent(
        uiState = uiState,
        tvSeries = tvSeries,
        modifier = modifier,
        onTVClick = { viewModel.nav.navigateToMovieDetail(it) },
        onAiringTodayClick = { viewModel.nav.navigateToTVsDetail(TVSortBy.AIRING_TODAY) },
        onPopularClick = { viewModel.nav.navigateToTVsDetail(TVSortBy.POPULAR) },
        onTopRatedClick = { viewModel.nav.navigateToTVsDetail(TVSortBy.TOP_RATED) },
        onTheAirClick = { viewModel.nav.navigateToTVsDetail(TVSortBy.ON_THE_AIR) },
    )
}

@Composable
private fun DiscoverTVContent(
    uiState: DiscoverTVUIState,
    tvSeries: Map<TVSortBy, Medias>,
    onTVClick: (id: Long) -> Unit,
    onAiringTodayClick: () -> Unit,
    onPopularClick: () -> Unit,
    onTopRatedClick: () -> Unit,
    onTheAirClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val isLoading = uiState is DiscoverTVUIState.Loading
    Box {
        Column(
            modifier
                .padding(
                    bottom = NavigationBarContainerHeight + MVDimen.Large
                )
                .verticalScroll(scrollState)
        ) {
            tvSeries[TVSortBy.TRENDING]?.let {
                TrendingItem(it, onTVClick)
                SpaceMedium()
            }
            tvSeries[TVSortBy.AIRING_TODAY]?.let {
                TVHeadline(
                    it,
                    TVSortBy.AIRING_TODAY,
                    onAiringTodayClick,
                    onTVClick
                )
                SpaceMedium()
            }

            tvSeries[TVSortBy.POPULAR]?.let {
                TVHeadline(
                    it,
                    TVSortBy.POPULAR,
                    onPopularClick,
                    onTVClick
                )
                SpaceMedium()
            }
            tvSeries[TVSortBy.TOP_RATED]?.let {
                TVHeadline(
                    it,
                    TVSortBy.TOP_RATED,
                    onTopRatedClick,
                    onTVClick
                )
                SpaceMedium()
            }
            tvSeries[TVSortBy.ON_THE_AIR]?.let {
                TVHeadline(
                    it,
                    TVSortBy.ON_THE_AIR,
                    onTheAirClick,
                    onTVClick
                )
            }
        }
        if (isLoading) {
            MVLoadingOverlay()
        }
    }
}

@Composable
private fun TVHeadline(
    medias: Medias,
    type: TVSortBy,
    onClick: () -> Unit,
    onTVClick: (Long) -> Unit
) {
    val strings = LocalResourceStrings.current
    MediaItemWithCategory(
        title = when (type) {
            TVSortBy.AIRING_TODAY -> strings.airingToday
            TVSortBy.POPULAR -> strings.popularNow
            TVSortBy.TOP_RATED -> strings.topRated
            TVSortBy.ON_THE_AIR -> strings.onTheAir
            TVSortBy.TRENDING -> strings.trending
        },
        data = medias,
        onClick = onClick,
        onMediaClick = onTVClick
    )
}

@ThemePreviews
@Composable
private fun DiscoverTVContentPreview() {
    PreviewWrapper {
        DiscoverTVContent(
            uiState = DiscoverTVUIState.Success,
            tvSeries = emptyMap(),
            onTVClick = {},
            onAiringTodayClick = {},
            onPopularClick = {},
            onTopRatedClick = {},
            onTheAirClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}