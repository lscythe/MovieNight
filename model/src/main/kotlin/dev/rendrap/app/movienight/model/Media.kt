package dev.rendrap.app.movienight.model

data class Media(
    val id: Long,
    val name: String,
    val originalName: String,
    val overview: String,
    val rating: Double,
    val poster: String,
    val genres: String,
    val adult: Boolean,
    val type: MediaType,
    val firstAirDate: String,
    val releaseDate: String,
)

enum class MediaType {
    TV_SERIES,
    MOVIES
}

typealias Medias = List<Media>