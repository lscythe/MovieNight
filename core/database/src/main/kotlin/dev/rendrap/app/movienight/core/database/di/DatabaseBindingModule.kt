package dev.rendrap.app.movienight.core.database.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.database.utils.PassphraseProvider
import dev.rendrap.app.movienight.core.database.utils.PassphraseProviderImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatabaseBindingModule {
    @Binds
    abstract fun bindPassphraseProvider(impl: PassphraseProviderImpl): PassphraseProvider
}