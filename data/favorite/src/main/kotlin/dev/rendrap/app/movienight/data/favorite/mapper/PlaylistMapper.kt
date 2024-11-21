package dev.rendrap.app.movienight.data.favorite.mapper

import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.core.database.entity.MediaPlaylist
import dev.rendrap.app.movienight.core.database.entity.PlaylistEntity
import dev.rendrap.app.movienight.model.Playlist

fun Playlist.toEntity() = PlaylistEntity(
    id = id,
    name = name,
    createdAt = createdAt
)

fun MediaPlaylist.toModel() = Playlist(
    id = playlist.id.orZero(),
    name = playlist.name,
    createdAt = playlist.createdAt,
    medias = media.map { it.toModel() }
)