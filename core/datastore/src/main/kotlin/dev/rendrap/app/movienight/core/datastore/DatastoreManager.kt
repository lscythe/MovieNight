package dev.rendrap.app.movienight.core.datastore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DatastoreManager {
    suspend fun <T> save(value: T, key: Preferences.Key<T>)
    fun <T> get(key: Preferences.Key<T>, defaultValue: T): Flow<T>
    fun <T> get(key: Preferences.Key<T>): Flow<T?>
    suspend fun <T> delete(key: Preferences.Key<T>)
    suspend fun clear()
}