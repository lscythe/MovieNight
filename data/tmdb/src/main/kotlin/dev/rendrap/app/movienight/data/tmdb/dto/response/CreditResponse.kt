package dev.rendrap.app.movienight.data.tmdb.dto.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditResponse(
    @SerialName("cast")
    val cast: List<CastResponse>? = null,
    @SerialName("crew")
    val crew: List<CrewResponse>? = null,
    @SerialName("id")
    val id: Int? = null
)

@Serializable
data class CastResponse(
    @SerialName("adult")
    val adult: Boolean? = null,
    @SerialName("cast_id")
    val castId: Int? = null,
    @SerialName("character")
    val character: String? = null,
    @SerialName("credit_id")
    val creditId: String? = null,
    @SerialName("gender")
    val gender: Int? = null,
    @SerialName("id")
    val id: Long? = null,
    @SerialName("known_for_department")
    val knownForDepartment: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("order")
    val order: Int? = null,
    @SerialName("original_name")
    val originalName: String? = null,
    @SerialName("popularity")
    val popularity: Double? = null,
    @SerialName("profile_path")
    val profilePath: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("poster_path")
    val posterPath: String? = null
)

@Serializable
data class CrewResponse(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("cast_id")
    val castId: Int,
    @SerialName("credit_id")
    val creditId: String,
    @SerialName("gender")
    val gender: Int,
    @SerialName("id")
    val id: Long,
    @SerialName("known_for_department")
    val knownForDepartment: String,
    @SerialName("name")
    val name: String,
    @SerialName("order")
    val order: Int,
    @SerialName("original_name")
    val originalName: String,
    @SerialName("popularity")
    val popularity: Double,
    @SerialName("profile_path")
    val profilePath: String,
    @SerialName("job")
    val job: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("poster_path")
    val posterPath: String? = null
)