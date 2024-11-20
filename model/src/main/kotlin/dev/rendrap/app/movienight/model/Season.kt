package dev.rendrap.app.movienight.model

data class Season(
    val name: String,
    val seasonNumber: Int,
)

data class SeasonDetail(
    val id: Int,
    val name: String,
    val airDate: String,
    val image: String,
    val episodeNumber: Int,
    val runtime: Int,
)