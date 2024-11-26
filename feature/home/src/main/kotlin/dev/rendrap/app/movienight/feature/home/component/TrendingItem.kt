package dev.rendrap.app.movienight.feature.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.common.extension.year
import dev.rendrap.app.movienight.core.designsystem.component.MVChip
import dev.rendrap.app.movienight.core.designsystem.component.SpaceExtraSmall
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism
import dev.rendrap.app.movienight.core.ui.TMDBNetworkImage
import dev.rendrap.app.movienight.model.Medias

@Composable
internal fun TrendingItem(
    medias: Medias,
    onClick: (id: Long) -> Unit
) {
    val pagerState = rememberPagerState { medias.size }

    Column(Modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .height(560.dp),
            contentPadding = PaddingValues(MVDimen.Regular),
            pageSpacing = MVDimen.Medium
        ) { page ->
            val trendingMovie = medias[page]

            Box(
                Modifier
                    .fillMaxSize()
                    .brutalism(shape = MVShape.ROUNDED)
                    .clickable { onClick(trendingMovie.id) }) {
                TMDBNetworkImage(trendingMovie.poster, modifier = Modifier.fillMaxSize())
                Row(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = MVDimen.Small),
                ) {
                    trendingMovie.genres.firstOrNull()?.let {
                        MVChip(
                            selected = true,
                            label = it,
                            backgroundColor = MaterialTheme.colorScheme.background
                        )
                    }
                    SpaceExtraSmall()
                    if (trendingMovie.adult) {
                        MVChip(
                            selected = true,
                            label = "18+",
                            backgroundColor = MaterialTheme.colorScheme.background
                        )
                        SpaceExtraSmall()
                    }
                    val date =
                        trendingMovie.releaseDate.ifBlank { trendingMovie.firstAirDate }
                    MVChip(
                        selected = true,
                        label = date.year(),
                        backgroundColor = MaterialTheme.colorScheme.background
                    )
                }
            }
        }
        SpaceExtraSmall()
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(medias.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) {
                    MaterialTheme.colorScheme.onBackground
                } else MaterialTheme.colorScheme.background

                Box(
                    Modifier
                        .size(MVDimen.Medium)
                        .brutalism(backgroundColor = color)
                )
                SpaceExtraSmall()
            }
        }
    }
}