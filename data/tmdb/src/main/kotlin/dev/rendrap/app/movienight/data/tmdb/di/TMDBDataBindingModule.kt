package dev.rendrap.app.movienight.data.tmdb.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.data.tmdb.repository.TMDBRepositoryImpl
import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class TMDBDataBindingModule {
    @Binds
    abstract fun bindTMDBRepository(impl: TMDBRepositoryImpl): TMDBRepository
}