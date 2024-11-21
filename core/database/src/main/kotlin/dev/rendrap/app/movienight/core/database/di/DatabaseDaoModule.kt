package dev.rendrap.app.movienight.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.database.MovieNightDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseDaoModule {
    @Provides
    @Singleton
    fun provideFavoriteDao(db: MovieNightDatabase) = db.favoriteDao()

    @Provides
    @Singleton
    fun providePlaylistDao(db: MovieNightDatabase) = db.playlistDao()
}