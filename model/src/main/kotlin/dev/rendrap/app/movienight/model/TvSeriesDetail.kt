package dev.rendrap.app.movienight.model

data class TvSeriesDetail(
    val id: Long,
    val adult: Boolean,
    val name: String,
    val originalName: String,
    val genres: String,
    val homepage: String,
    val firstAirDate: String,
    val poster: String,
    val rating: Double,
    val ratingCount: Int,
    val network: String,
    val originCountry: List<String>,
    val seasons: Seasons
)