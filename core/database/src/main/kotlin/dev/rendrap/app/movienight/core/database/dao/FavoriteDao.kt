package dev.rendrap.app.movienight.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import dev.rendrap.app.movienight.core.database.entity.FavoriteEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteEntity)

    @Query("SELECT * from favorites ORDER BY title")
    fun getAll(): PagingSource<Int, FavoriteEntity>

    @Query("SELECT * FROM FAVORITES ORDER BY createdAt LIMIT :limit")
    suspend fun getALl(limit: Int): List<FavoriteEntity>

    @Delete
    suspend fun delete(vararg favorite: FavoriteEntity)
}