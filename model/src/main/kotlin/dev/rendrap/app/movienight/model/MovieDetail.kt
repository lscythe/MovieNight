package dev.rendrap.app.movienight.model

data class MovieDetail(
    val id: Int,
    val name: String,
    val originalName: String,
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