package dev.rendrap.app.movienight.data.tmdb.datasource

import dev.rendrap.app.movienight.core.network.model.ApiResponse
import dev.rendrap.app.movienight.core.network.utils.safeRequest
import dev.rendrap.app.movienight.data.tmdb.di.TMDBApiScope
import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.CreditResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.MovieDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.MovieResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.PeopleDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.ReviewResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.SeasonDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.SimilarResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.TrendingResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.TvSeriesDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.TvSeriesResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.VideoResponse
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.AIRING_TODAY
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.COMBINED_CREDITS
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.CREDITS
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.MOVIE
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.NOW_PLAYING
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.ON_THE_AIR
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.PERSON
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.POPULAR
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.REVIEWS
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.SEASON
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.SIMILAR
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.TOP_RATED
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.TRENDING
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.TV
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.UPCOMING
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.VIDEOS
import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieType
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvType
import dev.rendrap.app.movienight.model.MediaType
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TMDBRemoteDataSource @Inject constructor(
    @TMDBApiScope private val client: HttpClient
) {
    suspend fun getMovies(
        param: MovieParameter
    ): ApiResponse<BaseResponses<MovieResponse>> =
        safeRequest {
            val url = when (param.type) {
                MovieType.NOW_PLAYING -> NOW_PLAYING
                MovieType.POPULAR -> POPULAR
                MovieType.TOP_RATED -> TOP_RATED
                MovieType.UPCOMING -> UPCOMING
            }
            client.get("$MOVIE/$url")
        }

    suspend fun getMovieDetail(
        id: Long
    ): ApiResponse<MovieDetailResponse> = safeRequest {
        client.get("$MOVIE/$id")
    }

    suspend fun getTrending(
        param: TrendingParameter
    ): ApiResponse<BaseResponses<TrendingResponse>> = safeRequest {
        val url = buildString {
            append("$TRENDING/")
            append(param.type.toMediaUrl())
            append("/${param.timeWindow.name.lowercase()}")
        }
        client.get(url)
    }

    suspend fun getTvSeries(
        param: TvParameter
    ): ApiResponse<BaseResponses<TvSeriesResponse>> = safeRequest {
        val type = when (param.type) {
            TvType.AIRING_TODAY -> AIRING_TODAY
            TvType.ON_THE_AIR -> ON_THE_AIR
            TvType.POPULAR -> POPULAR
            TvType.TOP_RATED -> TOP_RATED
        }
        client.get("$TV/$type")
    }

    suspend fun getTvSeriesDetail(
        id: Long
    ): ApiResponse<TvSeriesDetailResponse> = safeRequest {
        client.get("$TV/$id")
    }

    suspend fun getTvSeriesSeasonDetail(
        id: Long,
        seasonNumber: Int
    ): ApiResponse<SeasonDetailResponse> = safeRequest {
        client.get("$TV/$id/$SEASON/$seasonNumber")
    }

    suspend fun getCredits(
        type: MediaType,
        id: Long
    ): ApiResponse<CreditResponse> = safeRequest {
        client.get("${type.toMediaUrl()}/$id/$CREDITS")
    }

    suspend fun getReviews(
        type: MediaType,
        id: Long
    ): ApiResponse<BaseResponses<ReviewResponse>> = safeRequest {
        client.get("${type.toMediaUrl()}/$id/$REVIEWS")
    }

    suspend fun getSimilar(
        type: MediaType,
        id: Long
    ): ApiResponse<BaseResponses<SimilarResponse>> = safeRequest {
        client.get("${type.toMediaUrl()}/$id/$SIMILAR")
    }

    suspend fun getVideos(
        type: MediaType,
        id: Long
    ): ApiResponse<BaseResponses<VideoResponse>> =
        safeRequest {
            val url = buildString {
                append(type.toMediaUrl())
                append("/$id/")
                append(VIDEOS)
            }
            client.get(url)
        }

    suspend fun getPeopleDetail(id: Long): ApiResponse<PeopleDetailResponse> =
        safeRequest {
            client.get("$PERSON/$id")
        }

    suspend fun getPeopleCredit(id: Long): ApiResponse<CreditResponse> = safeRequest {
        client.get("$PERSON/$id/$COMBINED_CREDITS")
    }
}

private fun MediaType.toMediaUrl(): String = when (this) {
    MediaType.TV_SERIES -> TV
    MediaType.MOVIES -> MOVIE
}