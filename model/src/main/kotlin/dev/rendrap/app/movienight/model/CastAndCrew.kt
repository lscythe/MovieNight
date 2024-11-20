package dev.rendrap.app.movienight.model

data class CastAndCrew(
    val casts: List<CreditDetail>,
    val crews: List<CreditDetail>
)

data class CreditDetail(
    val id: Int,
    val name: String,
    val originalName: String,
    val character: String,
    val avatar: String,
    val job: String
)