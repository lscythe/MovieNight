package dev.rendrap.app.movienight.model

data class Season(
    val name: String,
    val seasonNumber: Int,
)

typealias Seasons = List<Season>

data class SeasonDetail(
    val episode: Episodes
)