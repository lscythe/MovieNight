package dev.rendrap.app.movienight.feature.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.component.MVTitleMedium
import dev.rendrap.app.movienight.core.designsystem.component.SpaceMedium
import dev.rendrap.app.movienight.core.designsystem.theme.MVDimen
import dev.rendrap.app.movienight.core.designsystem.theme.MVShape
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews
import dev.rendrap.app.movienight.core.designsystem.utils.brutalism
import dev.rendrap.app.movienight.core.resource.icons.MVIcon
import dev.rendrap.app.movienight.core.resource.icons.mvicon.ChevronRight
import dev.rendrap.app.movienight.core.ui.TMDBNetworkImage
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias

@Composable
internal fun MediaItemWithCategory(
    title: String,
    data: Medias,
    modifier: Modifier = Modifier,
    onMediaClick: (Long) -> Unit,
    onClick: () -> Unit
) {
    Column(modifier.wrapContentHeight()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = MVDimen.Regular),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            MVTitleMedium(title)
            Box(
                Modifier
                    .brutalism(
                        shape = MVShape.ROUNDED
                    )
                    .clickable { onClick() }
            ) {
                Icon(
                    MVIcon.ChevronRight,
                    contentDescription = "Item Click Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        SpaceMedium()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MVDimen.Medium),
            contentPadding = PaddingValues(horizontal = MVDimen.Regular)
        ) {
            items(data) { media ->
                TMDBNetworkImage(
                    url = media.poster,
                    modifier = Modifier
                        .width(100.dp)
                        .height(140.dp)
                        .brutalism(
                            shape = MVShape.ROUNDED,
                        )
                        .clickable { onMediaClick(media.id) }
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun MediaItemWithCategoryPreview() {
    PreviewWrapper {
        MediaItemWithCategory(
            title = "Now Playing",
            onMediaClick = {},
            data = List(8) {
                Media(
                    id = 1,
                    name = "Movie",
                    originalName = "Movie",
                    overview = "Overview",
                    rating = 5.0,
                    poster = "TODO()",
                    genres = listOf("Adult", "Drama"),
                    adult = true,
                    type = MediaType.MOVIES,
                    firstAirDate = "",
                    releaseDate = "2024-10-22"
                )
            }
        ) { }
    }
}