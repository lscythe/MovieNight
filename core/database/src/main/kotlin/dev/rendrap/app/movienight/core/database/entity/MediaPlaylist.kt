package dev.rendrap.app.movienight.core.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MediaPlaylist(
    @Embedded val playlist: PlaylistEntity,
    @Relation(
        parentColumn ="id",
        entityColumn = "playlistId"
    )
    val media: List<MediaEntity>
)