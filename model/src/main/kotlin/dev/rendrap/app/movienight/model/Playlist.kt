package dev.rendrap.app.movienight.model

import kotlinx.datetime.Instant

data class Playlist(
    val id: Int,
    val name: String,
    val createdAt: Instant,
    val medias: List<Media>
)

typealias Playlists = List<Playlist>