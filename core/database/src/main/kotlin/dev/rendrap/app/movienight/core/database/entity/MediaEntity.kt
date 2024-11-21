package dev.rendrap.app.movienight.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import dev.rendrap.app.movienight.model.MediaType
import kotlinx.datetime.Instant

@Entity(
    tableName = "medias",
    foreignKeys = [
        ForeignKey(
            PlaylistEntity::class,
            parentColumns = ["id"],
            childColumns = ["playlistId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MediaEntity(
    @PrimaryKey
    val mediaId: Long,
    val title: String,
    val poster: String,
    val genres: String,
    val rating: Double,
    val type: MediaType,
    val adult: Boolean,
    val releaseDate: Instant,
    val playlistId: Int
)