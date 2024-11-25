package dev.rendrap.app.movienight.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import dev.rendrap.app.movienight.model.MediaType
import kotlinx.datetime.LocalDate

@Entity(
    tableName = "medias",
    foreignKeys = [
        ForeignKey(
            PlaylistEntity::class,
            parentColumns = ["id"],
            childColumns = ["playlistId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["playlistId"], unique = true)]
)
data class MediaEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val originalTitle: String,
    val poster: String,
    val genres: String,
    val rating: Double,
    val type: MediaType,
    val adult: Boolean,
    val releaseDate: LocalDate? = null,
    val firstAirDate: LocalDate? = null,
    val playlistId: Int
)