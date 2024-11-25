package dev.rendrap.app.movienight.navigation.route

import dev.rendrap.app.movienight.feature.home.navigation.HomeNavigation
import dev.rendrap.app.movienight.model.MovieSortBy
import dev.rendrap.app.movienight.model.TVSortBy
import dev.rendrap.app.movienight.navigation.NavigationManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeNavigationImpl @Inject constructor(
    private val navManager: NavigationManager
) : HomeNavigation {
    override fun navigateToMoviesDetail(type: MovieSortBy) {
        TODO("Not yet implemented")
    }

    override fun navigateToTVsDetail(type: TVSortBy) {
        TODO("Not yet implemented")
    }

    override fun navigateToMovieDetail(id: Long) {
        TODO("Not yet implemented")
    }

    override fun navigateToTVDetail(id: Long) {
        TODO("Not yet implemented")
    }

}