package dev.rendrap.app.movienight.model

data class MovieDetail(
    val id: Long,
    val adult: Boolean,
    val name: String,
    val originalName: String,
    val genres: List<String>,
    val originCountry: List<String>,
    val poster: String,
    val homepage: String,
    val overview: String,
    val popularity: Double,
    val releaseDate: String,
    val rating: Double,
    val ratingCount: Long
)