package dev.rendrap.app.movienight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rendrap.app.movienight.core.common.utils.Theme
import dev.rendrap.app.movienight.domain.setting.usecase.GetCurrentLanguage
import dev.rendrap.app.movienight.domain.setting.usecase.GetCurrentTheme
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    getCurrentLanguage: GetCurrentLanguage,
    getCurrentTheme: GetCurrentTheme
) : ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = combine(
        getCurrentTheme(),
        getCurrentLanguage()
    ) { theme, language ->
        val currTheme = Theme.entries.first { it.name == theme }
        MainActivityUiState.Success(
            language = language,
            theme = currTheme
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )

}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(
        val language: String,
        val theme: Theme
    ) : MainActivityUiState
}