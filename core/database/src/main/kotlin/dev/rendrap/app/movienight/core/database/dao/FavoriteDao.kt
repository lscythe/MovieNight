package dev.rendrap.app.movienight.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import dev.rendrap.app.movienight.core.database.entity.FavoriteEntity

@Dao
interface FavoriteDao {
    @Upsert
    suspend fun upsert(favorite: FavoriteEntity)

    @Query("SELECT * from favorites ORDER BY title")
    fun getAll(): PagingSource<Int, FavoriteEntity>

    @Delete
    suspend fun delete(favorite: FavoriteEntity)
}