package dev.rendrap.app.movienight.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import dev.rendrap.app.movienight.core.database.entity.MediaEntity
import dev.rendrap.app.movienight.core.database.entity.MediaPlaylist
import dev.rendrap.app.movienight.core.database.entity.PlaylistEntity

@Dao
interface PlaylistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(playlist: PlaylistEntity)

    @Delete
    suspend fun deletePlaylist(vararg playlist: PlaylistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedia(media: MediaEntity)

    @Delete
    suspend fun deleteMedia(vararg media: MediaEntity)

    @Transaction
    @Query("SELECT * FROM playlist ORDER BY createdAt")
    fun getPlaylistWithMedia(): PagingSource<Int, MediaPlaylist>

    @Transaction
    @Query("SELECT * FROM playlist ORDER BY createdAt LIMIT :limit")
    suspend fun getPlaylistWithMedia(limit: Int): List<MediaPlaylist>
}