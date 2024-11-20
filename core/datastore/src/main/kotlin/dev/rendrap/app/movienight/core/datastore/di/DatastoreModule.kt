package dev.rendrap.app.movienight.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.common.di.ApplicationScope
import dev.rendrap.app.movienight.core.common.di.IODispatcher
import io.github.osipxd.security.crypto.createEncrypted
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class PlainDatastore

@Qualifier
@Retention
annotation class SecureDatastore

private const val PLAIN_DATASTORE_FILENAME = "json.preferences_pb"
private const val SECURE_DATASTORE_FILENAME = "secure_json.preferences_pb"

@Module
@InstallIn(SingletonComponent::class)
internal object DatastoreModule {
    @Provides
    @Singleton
    @PlainDatastore
    fun providePlainDatastore(
        @ApplicationContext context: Context,
        @IODispatcher ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create(
        scope = CoroutineScope(scope.coroutineContext + ioDispatcher)
    ) { context.dataStoreFile(PLAIN_DATASTORE_FILENAME) }

    @Provides
    @Singleton
    @SecureDatastore
    fun provideSecureDatastore(
        @ApplicationContext context: Context,
        @IODispatcher ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope
    ): DataStore<Preferences> = PreferenceDataStoreFactory.createEncrypted(
        scope = CoroutineScope(scope.coroutineContext + ioDispatcher)
    ) {
        EncryptedFile.Builder(
            context.dataStoreFile(SECURE_DATASTORE_FILENAME),
            context,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
    }
}