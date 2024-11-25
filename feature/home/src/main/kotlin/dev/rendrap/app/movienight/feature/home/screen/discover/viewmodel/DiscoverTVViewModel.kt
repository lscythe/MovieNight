package dev.rendrap.app.movienight.feature.home.screen.discover.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvType
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetTrending
import dev.rendrap.app.movienight.domain.tmdb.usecase.GetTvSeries
import dev.rendrap.app.movienight.feature.home.navigation.HomeNavigation
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.TVSortBy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import saschpe.log4k.Log
import javax.inject.Inject

@HiltViewModel
class DiscoverTVViewModel @Inject constructor(
    private val getTvSeries: GetTvSeries,
    private val getTrending: GetTrending,
    val nav: HomeNavigation
) : ViewModel() {
    private val _uiState: MutableStateFlow<DiscoverTVUIState> =
        MutableStateFlow(DiscoverTVUIState.Loading)
    val uiState: StateFlow<DiscoverTVUIState> = _uiState.asStateFlow()

    private val _trending: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val trending: StateFlow<Medias> = _trending.asStateFlow()

    private val _airingToday: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val airingToday: StateFlow<Medias> = _airingToday.asStateFlow()

    private val _popular: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val popular: StateFlow<Medias> = _popular.asStateFlow()

    private val _topRated: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val topRated: StateFlow<Medias> = _topRated.asStateFlow()

    private val _onTheAir: MutableStateFlow<Medias> = MutableStateFlow(emptyList())
    val onTheAir: StateFlow<Medias> = _onTheAir.asStateFlow()

    init {
        getTVs()
    }

    private fun getTVs() {
        resetValue()
        getTrending()
        getAiringToday()
        getPopular()
        getTopRated()
        getNowPlaying()
    }

    private fun getTrending() = viewModelScope.launch {
        _uiState.value = DiscoverTVUIState.Loading
        getTrending(TrendingParameter(type = MediaType.TV_SERIES)).collectLatest { result ->
            result.mapResultToState(TVSortBy.TRENDING)
        }
    }

    private fun getAiringToday() = viewModelScope.launch {
        _uiState.value = DiscoverTVUIState.Loading
        getTvSeries(TvParameter(type = TvType.AIRING_TODAY)).collectLatest { result ->
            result.mapResultToState(TVSortBy.AIRING_TODAY)
        }
    }

    private fun getPopular() = viewModelScope.launch {
        _uiState.value = DiscoverTVUIState.Loading
        getTvSeries(TvParameter(type = TvType.POPULAR)).collectLatest { result ->
            result.mapResultToState(TVSortBy.POPULAR)
        }
    }

    private fun getTopRated() = viewModelScope.launch {
        _uiState.value = DiscoverTVUIState.Loading
        getTvSeries(TvParameter(type = TvType.TOP_RATED)).collectLatest { result ->
            result.mapResultToState(TVSortBy.TOP_RATED)
        }
    }

    private fun getNowPlaying() = viewModelScope.launch {
        _uiState.value = DiscoverTVUIState.Loading
        getTvSeries(TvParameter(type = TvType.ON_THE_AIR)).collectLatest { result ->
            result.mapResultToState(TVSortBy.ON_THE_AIR)
        }
    }

    private fun Result<Medias>.mapResultToState(type: TVSortBy) {
        when (this) {
            is Result.Failure -> _uiState.update { DiscoverTVUIState.Error(this.exception.message.orEmpty()) }
            is Result.Success -> {
                Log.debug { "TV Series $type: ${this.data}" }
                _uiState.update { DiscoverTVUIState.Success }
                when (type) {
                    TVSortBy.AIRING_TODAY-> _airingToday.update { this.data.take(TV_LIMIT) }
                    TVSortBy.POPULAR -> _popular.update { this.data.take(TV_LIMIT) }
                    TVSortBy.TOP_RATED -> _topRated.update { this.data.take(TV_LIMIT) }
                    TVSortBy.ON_THE_AIR -> _onTheAir.update { this.data.take(TV_LIMIT) }
                    TVSortBy.TRENDING -> _trending.update { this.data.take(TV_LIMIT) }
                }
            }
        }
    }

    private fun resetValue() {
        _uiState.update { DiscoverTVUIState.Loading }
        _trending.update { emptyList() }
        _airingToday.update { emptyList() }
        _popular.update { emptyList() }
        _topRated.update { emptyList() }
        _onTheAir.update { emptyList() }
    }

    companion object {
        private const val TV_LIMIT = 8
    }
}

sealed interface DiscoverTVUIState {
    data object Loading : DiscoverTVUIState
    data class Error(val message: String) : DiscoverTVUIState
    data object Success : DiscoverTVUIState
}