package dev.rendrap.app.movienight.data.tmdb.dto.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    @SerialName("author")
    val author: String? = null,
    @SerialName("author_details")
    val authorDetails: AuthorDetails? = null,
    @SerialName("content")
    val content: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null,
    @SerialName("url")
    val url: String? = null
)

@Serializable
data class AuthorDetails(
    @SerialName("avatar_path")
    val avatarPath: String?,
    @SerialName("name")
    val name: String,
    @SerialName("rating")
    val rating: Int?,
    @SerialName("username")
    val username: String
)