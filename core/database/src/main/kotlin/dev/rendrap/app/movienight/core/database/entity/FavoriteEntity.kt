package dev.rendrap.app.movienight.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val poster: String,
    val genres: String,
    val rating: Double,
    val type: MediaType,
    val adult: Boolean,
    val releaseDate: Instant
)

enum class MediaType {
    MOVIES,
    TV_SERIES
}