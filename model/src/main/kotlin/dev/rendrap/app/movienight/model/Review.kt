package dev.rendrap.app.movienight.model

data class Review(
    val username: String,
    val avatar: String,
    val date: String,
    val content: String,
    val rating: Int
)

typealias Reviews = List<Review>