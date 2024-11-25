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
import dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel.DiscoverMovieUIState
import dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel.DiscoverMovieViewModel
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieSortBy

@Composable
internal fun DiscoverMovieContent(
    modifier: Modifier = Modifier,
    viewModel: DiscoverMovieViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val trending by viewModel.trending.collectAsStateWithLifecycle()
    val topRated by viewModel.topRated.collectAsStateWithLifecycle()
    val upcoming by viewModel.upcoming.collectAsStateWithLifecycle()
    val nowPlaying by viewModel.nowPlaying.collectAsStateWithLifecycle()
    val popular by viewModel.popular.collectAsStateWithLifecycle()

    val movies = mapOf(
        MovieSortBy.UPCOMING to upcoming,
        MovieSortBy.POPULAR to popular,
        MovieSortBy.TOP_RATED to topRated,
        MovieSortBy.NOW_PLAYING to nowPlaying,
        MovieSortBy.TRENDING to trending,
    )

    DiscoverMovieContent(
        uiState = uiState,
        movies = movies,
        modifier = modifier,
        onMovieClick = { viewModel.nav.navigateToMovieDetail(it) },
        onUpcomingClick = { viewModel.nav.navigateToMoviesDetail(MovieSortBy.UPCOMING) },
        onPopularClick = { viewModel.nav.navigateToMoviesDetail(MovieSortBy.POPULAR) },
        onTopRatedClick = { viewModel.nav.navigateToMoviesDetail(MovieSortBy.TOP_RATED) },
        onNowPlayingClick = { viewModel.nav.navigateToMoviesDetail(MovieSortBy.NOW_PLAYING) },
    )
}

@Composable
private fun DiscoverMovieContent(
    uiState: DiscoverMovieUIState,
    movies: Map<MovieSortBy, Medias>,
    onMovieClick: (id: Long) -> Unit,
    onUpcomingClick: () -> Unit,
    onPopularClick: () -> Unit,
    onTopRatedClick: () -> Unit,
    onNowPlayingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val isLoading = uiState is DiscoverMovieUIState.Loading
    Box {
        Column(
            modifier
                .padding(
                    bottom = NavigationBarContainerHeight + MVDimen.Large
                )
                .verticalScroll(scrollState)
        ) {
            movies[MovieSortBy.TRENDING]?.let {
                TrendingItem(it, onMovieClick)
                SpaceMedium()
            }
            movies[MovieSortBy.NOW_PLAYING]?.let {
                MovieHeadline(
                    it,
                    MovieSortBy.NOW_PLAYING,
                    onNowPlayingClick,
                    onMovieClick
                )
                SpaceMedium()
            }

            movies[MovieSortBy.POPULAR]?.let {
                MovieHeadline(
                    it,
                    MovieSortBy.POPULAR,
                    onPopularClick,
                    onMovieClick
                )
                SpaceMedium()
            }
            movies[MovieSortBy.TOP_RATED]?.let {
                MovieHeadline(
                    it,
                    MovieSortBy.TOP_RATED,
                    onTopRatedClick,
                    onMovieClick
                )
                SpaceMedium()
            }
            movies[MovieSortBy.UPCOMING]?.let {
                MovieHeadline(
                    it,
                    MovieSortBy.UPCOMING,
                    onUpcomingClick,
                    onMovieClick
                )
            }

        }
        if (isLoading) {
            MVLoadingOverlay()
        }
    }
}

@Composable
private fun MovieHeadline(
    medias: Medias,
    type: MovieSortBy,
    onClick: () -> Unit,
    onMovieClick: (Long) -> Unit
) {
    val strings = LocalResourceStrings.current
    MediaItemWithCategory(
        title = when (type) {
            MovieSortBy.UPCOMING -> strings.upcoming
            MovieSortBy.POPULAR -> strings.popularNow
            MovieSortBy.TOP_RATED -> strings.topRated
            MovieSortBy.NOW_PLAYING -> strings.nowPlaying
            MovieSortBy.TRENDING -> strings.trending
        },
        data = medias,
        onClick = onClick,
        onMediaClick = onMovieClick
    )
}

@ThemePreviews
@Composable
private fun DiscoverMovieContentPreview() {
    PreviewWrapper {
        DiscoverMovieContent(
            uiState = DiscoverMovieUIState.Success,
            movies = emptyMap(),
            onMovieClick = {},
            onUpcomingClick = {},
            onPopularClick = {},
            onTopRatedClick = {},
            onNowPlayingClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}