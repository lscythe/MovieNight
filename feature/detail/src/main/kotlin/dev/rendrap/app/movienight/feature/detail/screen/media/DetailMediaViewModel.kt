package dev.rendrap.app.movienight.feature.detail.screen.media

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetMovieDetail
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetSimilar
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetTvSeriesDetail
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetVideos
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail
import dev.rendrap.app.movienight.model.TvSeriesDetail
import dev.rendrap.app.movienight.model.Videos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMediaViewModel @Inject constructor(
    private val getTvSeriesDetail: GetTvSeriesDetail,
    private val getMovieDetail: GetMovieDetail,
    private val getSimilar: GetSimilar,
    private val getVideos: GetVideos,
) : ViewModel() {
    private val _uiState: MutableStateFlow<DetailMediaUIState> =
        MutableStateFlow(DetailMediaUIState.Loading)
    val uiState: StateFlow<DetailMediaUIState> = _uiState.asStateFlow()

    private val _movie: MutableStateFlow<MovieDetail?> = MutableStateFlow(null)
    val movie: StateFlow<MovieDetail?> = _movie.asStateFlow()

    private val _tvShow: MutableStateFlow<TvSeriesDetail?> = MutableStateFlow(null)
    val tvShow: StateFlow<TvSeriesDetail?> = _tvShow.asStateFlow()

    private val _similar: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val similar: StateFlow<Medias> = _similar.asStateFlow()

    private val _videos: MutableStateFlow<Videos> = MutableStateFlow(emptyList())
    val videos: StateFlow<Videos> = _videos.asStateFlow()

    fun tvSeriesDetail(id: Long) = viewModelScope.launch {
        getTvSeriesDetail(id).collectLatest { result ->
            when (result) {
                is Result.Failure -> handleError(result.exception)
                is Result.Success -> _tvShow.update { result.data }
            }
        }
    }

    fun movieDetail(id: Long) = viewModelScope.launch {
        getMovieDetail(id).collectLatest { result ->
            when (result) {
                is Result.Failure -> handleError(result.exception)
                is Result.Success -> _movie.update { result.data }
            }
        }
    }

    fun similarMedia(id: Long, type: MediaType) = viewModelScope.launch {
        getSimilar(type, id).collectLatest { result ->
            when (result) {
                is Result.Failure -> handleError(result.exception)
                is Result.Success -> _similar.update { result.data }
            }
        }
    }

    fun videos(id: Long, type: MediaType) = viewModelScope.launch {
        getVideos(type, id).collectLatest { result ->
            when (result) {
                is Result.Failure -> handleError(result.exception)
                is Result.Success -> _videos.update { result.data }
            }
        }
    }

    private fun handleError(throwable: Throwable) {
        _uiState.update { DetailMediaUIState.Error(throwable.message.orEmpty()) }
    }
}

sealed interface DetailMediaUIState {
    data object Loading : DetailMediaUIState
    data class Error(val message: String) : DetailMediaUIState
    data object Success : DetailMediaUIState
}