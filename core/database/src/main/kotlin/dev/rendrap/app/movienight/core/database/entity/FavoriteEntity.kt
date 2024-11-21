package dev.rendrap.app.movienight.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.rendrap.app.movienight.model.MediaType
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

@Entity(tableName = "favorites")
data class FavoriteEntity(
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
    val createdAt: Instant
)