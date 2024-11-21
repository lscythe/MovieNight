package dev.rendrap.app.movienight.data.favorite.di

import dagger.Binds
import dev.rendrap.app.movienight.data.favorite.repository.FavoriteRepositoryImpl
import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import javax.inject.Singleton

@Singleton
internal abstract class FavoriteDataBindingModule {
    @Binds
    abstract fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository
}