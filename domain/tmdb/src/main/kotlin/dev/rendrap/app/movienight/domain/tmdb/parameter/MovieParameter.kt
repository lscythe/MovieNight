package dev.rendrap.app.movienight.domain.tmdb.parameter

data class MovieParameter(
    val language: String = "en-US",
    val region: String? = null,
    val type: MovieType,
)

enum class MovieType {
    NOW_PLAYING,
    POPULAR,
    TOP_RATED,
    UPCOMING
}