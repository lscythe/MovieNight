package dev.rendrap.app.movienight.feature.player.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.SecureFlagPolicy
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun PlayerScreen(
    url: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
    ) {
        VideoPlayer(
            mediaItems = listOf(
                VideoPlayerMediaItem.NetworkMediaItem(
                    url = url
                )
            ),
            handleLifecycle = true,
            autoPlay = true,
            fullScreenSecurePolicy = SecureFlagPolicy.SecureOff,
            usePlayerController = true,
            repeatMode = RepeatMode.NONE,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
    }
}