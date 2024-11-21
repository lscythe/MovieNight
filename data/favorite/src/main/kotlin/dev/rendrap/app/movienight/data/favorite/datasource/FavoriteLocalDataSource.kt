package dev.rendrap.app.movienight.data.favorite.datasource

import dev.rendrap.app.movienight.core.database.dao.FavoriteDao
import dev.rendrap.app.movienight.core.database.dao.PlaylistDao
import dev.rendrap.app.movienight.core.database.entity.PlaylistEntity
import dev.rendrap.app.movienight.data.favorite.mapper.toEntity
import dev.rendrap.app.movienight.data.favorite.mapper.toFavoriteEntity
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.Playlist
import kotlinx.datetime.Clock
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteLocalDataSource @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val playlistDao: PlaylistDao
) {
    suspend fun addFavorite(media: Media) = favoriteDao.insert(media.toFavoriteEntity())

    suspend fun addMediaToPlaylist(media: Media, playlistId: Int) =
        playlistDao.insertMedia(media.toEntity(playlistId))

    suspend fun addPlaylist(name: String) =
        playlistDao.insertPlaylist(PlaylistEntity(name = name, createdAt = Clock.System.now()))

    suspend fun deleteFavorite(vararg media: Media) =
        favoriteDao.delete(*media.map { it.toFavoriteEntity() }.toTypedArray())

    suspend fun deleteMedia(vararg media: Media, playlistId: Int) =
        playlistDao.deleteMedia(*media.map { it.toEntity(playlistId) }.toTypedArray())

    suspend fun deletePlaylist(vararg playlist: Playlist) =
        playlistDao.deletePlaylist(*playlist.map { it.toEntity() }.toTypedArray())

    fun getFavorites() = favoriteDao.getAll()

    suspend fun getFavorites(limit: Int) = favoriteDao.getALl(limit)

    fun getPlaylist() = playlistDao.getPlaylistWithMedia()

    suspend fun getPlaylist(limit: Int) = playlistDao.getPlaylistWithMedia(limit)
}