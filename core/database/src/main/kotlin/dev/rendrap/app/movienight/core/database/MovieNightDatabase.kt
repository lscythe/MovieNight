package dev.rendrap.app.movienight.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.rendrap.app.movienight.core.database.MovieNightDatabase.Companion.DATABASE_VERSION
import dev.rendrap.app.movienight.core.database.converter.InstantConverter
import dev.rendrap.app.movienight.core.database.dao.FavoriteDao
import dev.rendrap.app.movienight.core.database.entity.FavoriteEntity

@Database(
    entities = [FavoriteEntity::class],
    version = DATABASE_VERSION
)
@TypeConverters(
    InstantConverter::class
)
internal abstract class MovieNightDatabase : RoomDatabase() {
    internal abstract fun favoriteDao(): FavoriteDao

    companion object {
        const val DATABASE_NAME = "movie_night_db"
        const val DATABASE_VERSION = 1
    }
}