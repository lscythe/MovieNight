package dev.rendrap.app.movienight.domain.favorite.repository

import androidx.paging.PagingData
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.Playlist
import dev.rendrap.app.movienight.model.Playlists
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun addFavorite(media: Media)
    suspend fun addMediaToPlaylist(media: Media, playlistId: Int)
    suspend fun addPlaylist(name: String)
    suspend fun deleteFavorite(vararg media: Media)
    suspend fun deleteMedia(vararg media: Media, playlistId: Int)
    suspend fun deletePlaylist(vararg playlist: Playlist)
    fun getFavorites(): Flow<PagingData<Media>>
    suspend fun getFavorites(limit: Int): Flow<Result<Medias>>
    fun getPlaylists(): Flow<PagingData<Playlist>>
    suspend fun getPlaylists(limit: Int): Flow<Result<Playlists>>
}