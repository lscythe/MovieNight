package dev.rendrap.app.movienight.model

sealed interface Result<T> {
    data object Loading : Result<Nothing>
    data class Success<T>(val data: T) : Result<T>
    data class Error(val title: String, val message: String) : Result<Nothing>
}