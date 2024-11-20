package dev.rendrap.app.movienight.model

data class Movie(
    val id: Long,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val rating: Double,
    val poster: String,
    val genres: String,
    val adult: Boolean,
)

data class MovieDetail(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val genres: String,
    val originCountry: List<String>,
    val poster: String,
    val homepage: String,
    val overview: String,
    val popularity: Long,
    val releaseDate: String,
    val rating: Double,
    val ratingCount: Long
)