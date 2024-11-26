package dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieType
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetMovies
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetTrending
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieSortBy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverMovieViewModel @Inject constructor(
    private val getMovies: GetMovies,
    private val getTrending: GetTrending,
) : ViewModel() {
    private val _uiState: MutableStateFlow<DiscoverMovieUIState> =
        MutableStateFlow(DiscoverMovieUIState.Loading)
    val uiState: StateFlow<DiscoverMovieUIState> = _uiState.asStateFlow()

    private val _trending: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val trending: StateFlow<Medias> = _trending.asStateFlow()

    private val _upcoming: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val upcoming: StateFlow<Medias> = _upcoming.asStateFlow()

    private val _popular: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val popular: StateFlow<Medias> = _popular.asStateFlow()

    private val _topRated: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val topRated: StateFlow<Medias> = _topRated.asStateFlow()

    private val _nowPlaying: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val nowPlaying: StateFlow<Medias> = _nowPlaying.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        resetValue()
        getTrending()
        getUpcoming()
        getPopular()
        getTopRated()
        getNowPlaying()
    }

    private fun getTrending() = viewModelScope.launch {
        _uiState.value = DiscoverMovieUIState.Loading
        getTrending(TrendingParameter(type = MediaType.MOVIES)).collectLatest { result ->
            result.mapResultToState(MovieSortBy.TRENDING)
        }
    }

    private fun getUpcoming() = viewModelScope.launch {
        _uiState.value = DiscoverMovieUIState.Loading
        getMovies(MovieParameter(type = MovieType.UPCOMING)).collectLatest { result ->
            result.mapResultToState(MovieSortBy.UPCOMING)
        }
    }

    private fun getPopular() = viewModelScope.launch {
        _uiState.value = DiscoverMovieUIState.Loading
        getMovies(MovieParameter(type = MovieType.POPULAR)).collectLatest { result ->
            result.mapResultToState(MovieSortBy.POPULAR)
        }
    }

    private fun getTopRated() = viewModelScope.launch {
        _uiState.value = DiscoverMovieUIState.Loading
        getMovies(MovieParameter(type = MovieType.TOP_RATED)).collectLatest { result ->
            result.mapResultToState(MovieSortBy.TOP_RATED)
        }
    }

    private fun getNowPlaying() = viewModelScope.launch {
        _uiState.value = DiscoverMovieUIState.Loading
        getMovies(MovieParameter(type = MovieType.NOW_PLAYING)).collectLatest { result ->
            result.mapResultToState(MovieSortBy.NOW_PLAYING)
        }
    }

    private fun Result<Medias>.mapResultToState(type: MovieSortBy) {
        _uiState.value = DiscoverMovieUIState.Loading
        when (this) {
            is Result.Failure -> _uiState.update { DiscoverMovieUIState.Error(this.exception.message.orEmpty()) }
            is Result.Success -> {
                _uiState.update { DiscoverMovieUIState.Success }
                when (type) {
                    MovieSortBy.UPCOMING -> _upcoming.update { this.data.take(MOVIE_LIMIT) }
                    MovieSortBy.POPULAR -> _popular.update { this.data.take(MOVIE_LIMIT) }
                    MovieSortBy.TOP_RATED -> _topRated.update { this.data.take(MOVIE_LIMIT) }
                    MovieSortBy.NOW_PLAYING -> _nowPlaying.update { this.data.take(MOVIE_LIMIT) }
                    MovieSortBy.TRENDING -> _trending.update { this.data.take(MOVIE_LIMIT) }
                }
            }
        }
    }

    private fun resetValue() {
        _uiState.update { DiscoverMovieUIState.Loading }
        _trending.update { emptyList() }
        _upcoming.update { emptyList() }
        _popular.update { emptyList() }
        _topRated.update { emptyList() }
        _nowPlaying.update { emptyList() }
    }

    companion object {
        private const val MOVIE_LIMIT = 8
    }
}

sealed interface DiscoverMovieUIState {
    data object Loading : DiscoverMovieUIState
    data class Error(val message: String) : DiscoverMovieUIState
    data object Success : DiscoverMovieUIState
}