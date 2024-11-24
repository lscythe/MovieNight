package dev.rendrap.app.movienight.core.ui

interface ViewState {
    data object Initial: ViewState
    data object Loading: ViewState
    data class Error(val title: String, val message: String)
}