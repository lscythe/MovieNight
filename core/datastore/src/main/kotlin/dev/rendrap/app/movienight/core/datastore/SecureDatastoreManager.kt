package dev.rendrap.app.movienight.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import dev.rendrap.app.movienight.core.datastore.di.SecureDatastore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SecureDatastoreManagerImpl @Inject constructor(
    @SecureDatastore private val dataStore: DataStore<Preferences>
) : DatastoreManager {

    override suspend fun <T> save(value: T, key: Preferences.Key<T>) {
        dataStore.edit { it[key] = value }
    }

    override fun <T> get(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
        dataStore.data.map { it[key] ?: defaultValue }

    override fun <T> get(key: Preferences.Key<T>): Flow<T?> =
        dataStore.data.map { it[key] }

    override suspend fun <T> delete(key: Preferences.Key<T>) {
        dataStore.edit { it.remove(key) }
    }

    override suspend fun clear() {
        dataStore.edit { it.clear() }
    }

}