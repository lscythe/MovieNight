package dev.rendrap.app.movienight.data.tmdb.dto.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvSeriesDetailResponse(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("first_air_date")
    val firstAirDate: String,
    @SerialName("genres")
    val genres: List<GenreResponse>,
    @SerialName("homepage")
    val homepage: String? = null,
    @SerialName("id")
    val id: Long,
    @SerialName("in_production")
    val inProduction: Boolean,
    @SerialName("last_air_date")
    val lastAirDate: String,
    @SerialName("name")
    val name: String,
    @SerialName("number_of_episodes")
    val numberOfEpisodes: Int,
    @SerialName("number_of_seasons")
    val numberOfSeasons: Int,
    @SerialName("origin_country")
    val originCountry: List<String>,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_name")
    val originalName: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("popularity")
    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("seasons")
    val seasons: List<SeasonResponse>,
    @SerialName("status")
    val status: String,
    @SerialName("tagline")
    val tagline: String,
    @SerialName("type")
    val type: String,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int
)

@Serializable
data class SeasonResponse(
    @SerialName("air_date")
    val airDate: String,
    @SerialName("episode_count")
    val episodeCount: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("season_number")
    val seasonNumber: Int,
    @SerialName("vote_average")
    val voteAverage: Double
)