package dev.rendrap.app.movienight.model

data class Media(
    val id: Long,
    val name: String,
    val originalName: String,
    val overview: String,
    val rating: Double,
    val poster: String,
    val genres: List<String>,
    val adult: Boolean,
    val type: MediaType,
    val firstAirDate: String,
    val releaseDate: String,
)

enum class MediaType {
    TV_SERIES,
    MOVIES
}

enum class MovieSortBy {
    UPCOMING,
    POPULAR,
    TOP_RATED,
    NOW_PLAYING,
    TRENDING
}

enum class TVSortBy {
    POPULAR,
    TOP_RATED,
    ON_THE_AIR,
    AIRING_TODAY,
    TRENDING
}

typealias Medias = List<Media>