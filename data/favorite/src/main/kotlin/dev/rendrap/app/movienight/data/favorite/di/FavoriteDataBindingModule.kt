package dev.rendrap.app.movienight.data.favorite.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.data.favorite.repository.FavoriteRepositoryImpl
import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class FavoriteDataBindingModule {
    @Binds
    abstract fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository
}