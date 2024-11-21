package dev.rendrap.app.movienight.model

data class Episode(
    val airDate: String,
    val episodeNumber: Int,
    val episodeType: String,
    val name: String,
    val runTime: Int,
    val stillPath: String,
)

typealias Episodes = List<Episode>