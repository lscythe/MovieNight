package dev.rendrap.app.movienight.feature.detail.screen.media

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.rendrap.app.movienight.core.common.extension.isNotNull
import dev.rendrap.app.movienight.core.common.extension.orFalse
import dev.rendrap.app.movienight.core.common.extension.year
import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.core.common.utils.Constants.TWO
import dev.rendrap.app.movienight.core.designsystem.component.MVHeadlineLarge
import dev.rendrap.app.movienight.core.designsystem.component.MVIconButton
import dev.rendrap.app.movienight.core.designsystem.component.MVTitleMedium
import dev.rendrap.app.movienight.core.designsystem.component.MVTopAppBar
import dev.rendrap.app.movienight.core.designsystem.extension.ifNotNull
import dev.rendrap.app.movienight.core.designsystem.theme.LocalMVColor
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism
import dev.rendrap.app.movienight.core.resource.icons.MVIcon
import dev.rendrap.app.movienight.core.resource.icons.mvicon.ArrowLeft
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Play
import dev.rendrap.app.movienight.core.ui.TMDBNetworkImage
import dev.rendrap.app.movienight.feature.detail.utils.buildYoutubeUrl
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail
import dev.rendrap.app.movienight.model.TvSeriesDetail
import dev.rendrap.app.movienight.model.Video
import dev.rendrap.app.movienight.model.Videos

@Composable
fun MediaScreen(
    media: Pair<Long, MediaType>,
    modifier: Modifier = Modifier,
    viewModel: DetailMediaViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onPlayClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val movie by viewModel.movie.collectAsStateWithLifecycle()
    val tvShow by viewModel.tvShow.collectAsStateWithLifecycle()
    val similar by viewModel.similar.collectAsStateWithLifecycle()
    val video by viewModel.videos.collectAsStateWithLifecycle()
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(media) {
        when (media.second) {
            MediaType.TV_SERIES -> viewModel.tvSeriesDetail(media.first)
            MediaType.MOVIES -> viewModel.movieDetail(media.first)
        }
        viewModel.similarMedia(media.first, media.second)
        viewModel.videos(media.first, media.second)
    }

    MediaScreen(
        uiState = uiState,
        movie = movie,
        tvShow = tvShow,
        similar = similar,
        video = video,
        modifier = modifier,
        onBackClick = onBackClick,
        onClickPlay = { uriHandler.openUri(it) }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MediaScreen(
    uiState: DetailMediaUIState,
    movie: MovieDetail?,
    tvShow: TvSeriesDetail?,
    similar: Medias,
    video: Videos,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onClickPlay: (String) -> Unit
) {
    val isLoading = uiState is DetailMediaUIState.Loading
    val color = LocalMVColor.current

    Box(
        modifier
            .fillMaxSize()
            .background(color.background)
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Column {
                    MediaPoster(
                        movie?.poster ?: tvShow?.poster.orEmpty(),
                        video = video.firstOrNull(),
                        isMovie = movie.isNotNull(),
                        onPlayClick = onClickPlay
                    )
                }
            }
            item {
                Divider()
            }
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = MVDimen.Regular),
                    verticalArrangement = Arrangement.Center
                ) {
                    MVHeadlineLarge(
                        text = movie?.name ?: tvShow?.name.orEmpty(),
                        modifier = Modifier.padding(horizontal = MVDimen.Regular),
                        maxLines = TWO
                    )
                }
            }
            item {
                Divider()
            }
            item {
                MediaShortInfo(
                    isAdult = movie?.adult ?: tvShow?.adult.orFalse(),
                    originCountry =
                    movie?.originCountry?.first() ?: tvShow?.originCountry?.first().orEmpty(),
                    genre = movie?.genres?.first() ?: tvShow?.genres?.first().orEmpty(),
                    date = movie?.releaseDate ?: tvShow?.firstAirDate.orEmpty()
                )
            }
            item {
                Divider()
            }
            item {
                MVTitleMedium(
                    text = movie?.overview ?: tvShow?.overview.orEmpty(),
                    modifier = Modifier.padding(MVDimen.Regular)
                )
            }
            item {
                Divider()
            }
        }
        MVTopAppBar(
            title = EMPTY_STRING,
            navigationIcon = {
                MVIconButton(MVIcon.ArrowLeft, onClick = onBackClick)
            },
            modifier = Modifier.padding(horizontal = MVDimen.Regular),
            backgroundColor = Color.Transparent
        )
    }
}

@Composable
private fun LazyItemScope.MediaPoster(
    poster: String,
    video: Video?,
    isMovie: Boolean,
    onPlayClick: (String) -> Unit,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(560.dp)
            .animateItem(),
        contentAlignment = Alignment.Center
    ) {
        TMDBNetworkImage(
            url = poster,
            modifier = Modifier.fillMaxSize()
        )
        if (isMovie) {
            Box(
                modifier = Modifier
                    .brutalism(shape = MVShape.FULL)
                    .size(64.dp)
                    .ifNotNull(video) { clickable { onPlayClick(video!!.key.buildYoutubeUrl()) } }
                    .padding(MVDimen.Small),
                contentAlignment = Alignment.Center
            ) {
                Icon(MVIcon.Play, contentDescription = "Play Icon")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun LazyItemScope.MediaShortInfo(
    isAdult: Boolean,
    originCountry: String,
    genre: String,
    date: String,
) {
    FlowRow(
        Modifier
            .padding(MVDimen.Regular)
            .animateItem(),
        horizontalArrangement = Arrangement.spacedBy(MVDimen.Small)
    ) {
        if (genre.isNotBlank()) MediaChip(label = genre)
        if (isAdult) MediaChip(label = "18+")
        if (originCountry.isNotBlank()) MediaChip(label = originCountry)
        if (date.isNotBlank()) MediaChip(label = date.year())
    }
}

@Composable
private fun LazyItemScope.Divider() {
    Spacer(
        Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(MaterialTheme.colorScheme.onBackground)
            .animateItem()
    )
}

@Composable
private fun MediaChip(
    label: String
) {
    Box(
        Modifier
            .brutalism(shape = MVShape.ROUNDED)
            .padding(horizontal = MVDimen.Medium, vertical = MVDimen.Small)
    ) {
        MVTitleMedium(label)
    }
}

@ThemePreviews
@Composable
private fun MediaScreenPreview() {
    PreviewWrapper {
        MediaScreen(
            uiState = DetailMediaUIState.Success,
            movie = MovieDetail(
                id = 1,
                name = "Dear Santa",
                originalName = "Dear Santa",
                genres = listOf("Drama", "Adventure"),
                originCountry = listOf("United States"),
                poster = "",
                homepage = "",
                overview = "Lorem Ipsum",
                popularity = 20.0,
                releaseDate = "2024-12-1",
                rating = 5.6,
                ratingCount = 12,
                adult = true
            ),
            tvShow = null,
            similar = emptyList(),
            onBackClick = {},
            onClickPlay = {},
            video = emptyList(),
        )
    }
}