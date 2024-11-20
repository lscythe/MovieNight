package dev.rendrap.app.movienight.core.datastore.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.datastore.DatastoreManager
import dev.rendrap.app.movienight.core.datastore.PlainDatastoreManagerImpl
import dev.rendrap.app.movienight.core.datastore.SecureDatastoreManagerImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatastoreBindingModule {
    @Binds
    @PlainDatastore
    abstract fun bindPlainDatastoreManager(impl: PlainDatastoreManagerImpl): DatastoreManager

    @Binds
    @SecureDatastore
    abstract fun bindSecureDatastoreManager(impl: SecureDatastoreManagerImpl): DatastoreManager

}