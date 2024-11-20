package dev.rendrap.app.movienight.domain.tmdb.parameter

data class TvParameter(
    val language: String = "en-US",
    val timezone: String? = null,
    val type: TvType
)

enum class TvType {
    AIRING_TODAY,
    ON_THE_AIR,
    POPULAR,
    TOP_RATED
}