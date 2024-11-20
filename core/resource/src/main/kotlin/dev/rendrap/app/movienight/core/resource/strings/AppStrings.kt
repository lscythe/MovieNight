package dev.rendrap.app.movienight.core.resource.strings

import androidx.compose.runtime.Composable
import cafe.adriel.lyricist.LocalStrings

val strings: AppStrings
    @Composable
    get() = LocalStrings.current

data class AppStrings(
    val search: String
)