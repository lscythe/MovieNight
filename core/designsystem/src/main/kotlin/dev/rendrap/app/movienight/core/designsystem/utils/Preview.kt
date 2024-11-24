package dev.rendrap.app.movienight.core.designsystem.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rendrap.app.movienight.core.designsystem.theme.MVTheme

@Composable
fun PreviewWrapper(
    content: @Composable BoxScope.() -> Unit
) {
    MVTheme {
        Box(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp),
        ) {
            content()
        }
    }
}