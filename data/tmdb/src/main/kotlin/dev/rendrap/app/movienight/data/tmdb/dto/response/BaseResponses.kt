package dev.rendrap.app.movienight.data.tmdb.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponses<T>(
    val page: Int? = null,
    val results: List<T>,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)