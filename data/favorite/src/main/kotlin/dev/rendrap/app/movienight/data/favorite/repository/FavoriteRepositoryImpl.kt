package dev.rendrap.app.movienight.data.favorite.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.core.common.map
import dev.rendrap.app.movienight.core.common.utils.Constants.TEN
import dev.rendrap.app.movienight.core.database.utils.resultLocalFlow
import dev.rendrap.app.movienight.data.favorite.datasource.FavoriteLocalDataSource
import dev.rendrap.app.movienight.data.favorite.mapper.toModel
import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.Playlist
import dev.rendrap.app.movienight.model.Playlists
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepositoryImpl @Inject constructor(
    private val localDataSource: FavoriteLocalDataSource
) : FavoriteRepository {
    override suspend fun addFavorite(media: Media) = localDataSource.addFavorite(media)

    override suspend fun addMediaToPlaylist(media: Media, playlistId: Int) =
        localDataSource.addMediaToPlaylist(media, playlistId)

    override suspend fun addPlaylist(name: String) = localDataSource.addPlaylist(name)

    override suspend fun deleteFavorite(vararg media: Media) =
        localDataSource.deleteFavorite(*media)

    override suspend fun deleteMedia(vararg media: Media, playlistId: Int) =
        localDataSource.deleteMedia(*media, playlistId = playlistId)

    override suspend fun deletePlaylist(vararg playlist: Playlist) =
        localDataSource.deletePlaylist(*playlist)

    override fun getFavorites(): Flow<PagingData<Media>> = Pager(
        config = PagingConfig(TEN)
    ) { localDataSource.getFavorites() }.flow.map {
        it.map { fav -> fav.toModel() }
    }

    override suspend fun getFavorites(limit: Int): Flow<Result<Medias>> = resultLocalFlow {
        localDataSource.getFavorites(limit)
    }.map {
        it.map { res -> res.map { fav -> fav.toModel() } }
    }

    override fun getPlaylists(): Flow<PagingData<Playlist>> = Pager(
        config = PagingConfig(TEN),
    ) { localDataSource.getPlaylist() }.flow.map {
        it.map { play -> play.toModel() }
    }

    override suspend fun getPlaylists(limit: Int): Flow<Result<Playlists>> = resultLocalFlow {
        localDataSource.getPlaylist(limit)
    }.map {
        it.map { res -> res.map { play -> play.toModel() } }
    }

}