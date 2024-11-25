package dev.rendrap.app.movienight.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "Network Image",
        modifier = modifier,
        contentScale = contentScale,
        placeholder = painterResource(R.drawable.ic_image),
        error = painterResource(R.drawable.ic_image_broken)
    )
}

@Composable
fun TMDBNetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillBounds,
) {
    SubcomposeAsyncImage(
        model = "$TMDB_IMAGE_URL$url",
        contentDescription = "Network Image",
        modifier = modifier,
        contentScale = contentScale,
        loading = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) { MVLoading() }
        },
        error = {
            Image(painterResource(R.drawable.ic_image_broken), contentDescription)
        }
    )
}

private const val TMDB_IMAGE_URL = "https://image.tmdb.org/t/p/w500"