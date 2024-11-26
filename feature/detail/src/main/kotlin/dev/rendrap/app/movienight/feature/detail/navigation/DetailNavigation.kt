package dev.rendrap.app.movienight.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import dev.rendrap.app.movienight.model.MediaType
import kotlinx.serialization.Serializable

@Serializable
data object DetailNavGraph

sealed interface DetailRoute {
    @Serializable
    data class Movie(val id: Long) : DetailRoute

    @Serializable
    data class TvShow(val id: Long) : DetailRoute

    @Serializable
    data class List(val type: MediaType, val name: String) : DetailRoute

    @Serializable
    data class People(val id: Long) : DetailRoute

    @Serializable
    data class CrewAndCast(val id: Long) : DetailRoute
}

fun NavController.navigateToDetail(
    destination: DetailRoute,
    navOptions: NavOptions
) = navigate(route = destination, navOptions = navOptions)