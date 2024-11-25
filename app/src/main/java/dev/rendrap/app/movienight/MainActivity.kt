package dev.rendrap.app.movienight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dev.rendrap.app.movienight.core.common.utils.Locales
import dev.rendrap.app.movienight.core.common.utils.NetworkMonitor
import dev.rendrap.app.movienight.core.common.utils.Theme
import dev.rendrap.app.movienight.core.designsystem.theme.MVTheme
import dev.rendrap.app.movienight.core.resource.ProvideResourceStrings
import dev.rendrap.app.movienight.core.resource.rememberResourceStrings
import dev.rendrap.app.movienight.navigation.NavigationManager
import dev.rendrap.app.movienight.ui.MovieNightApp
import dev.rendrap.app.movienight.ui.rememberMovieNightAppState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Inject
    lateinit var navigationManager: NavigationManager

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach { uiState = it }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }

        enableEdgeToEdge()
        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)
            val strings = rememberResourceStrings(
                defaultLanguageTag = Locales.EN_US,
                currentLanguageTag = currentLanguage(uiState)
            )

            val appState = rememberMovieNightAppState(
                networkMonitor = networkMonitor,
                navigationManager = navigationManager,
            )

            MVTheme(
                darkTheme = darkTheme
            ) {
                ProvideResourceStrings(strings) {
                    MovieNightApp(appState)
                }
            }
        }
    }
}

@Composable
private fun shouldUseDarkTheme(
    uiState: MainActivityUiState
): Boolean = when (uiState) {
    MainActivityUiState.Loading -> isSystemInDarkTheme()
    is MainActivityUiState.Success -> when (uiState.theme) {
        Theme.LIGHT -> false
        Theme.DARK -> true
        Theme.FOLLOW_SYSTEM -> isSystemInDarkTheme()
    }
}

@Composable
private fun currentLanguage(
    uiState: MainActivityUiState
): String = when (uiState) {
    MainActivityUiState.Loading -> Locales.EN_US
    is MainActivityUiState.Success -> uiState.language
}