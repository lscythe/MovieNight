package dev.rendrap.app.movienight.domain.tmdb.repository

import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.model.Credits
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail
import dev.rendrap.app.movienight.model.People
import dev.rendrap.app.movienight.model.Result
import dev.rendrap.app.movienight.model.Reviews
import dev.rendrap.app.movienight.model.SeasonDetail
import dev.rendrap.app.movienight.model.TvSeriesDetail
import dev.rendrap.app.movienight.model.Videos
import kotlinx.coroutines.flow.Flow

interface TMDBRepository {
    fun getMovies(param: MovieParameter): Flow<Result<Medias>>
    fun getMovieDetail(id: Long): Flow<Result<MovieDetail>>
    fun getMovieVideos(id: Long): Flow<Result<Videos>>
    fun getTrending(param: TrendingParameter): Flow<Result<Medias>>
    fun getTvSeries(param: TvParameter): Flow<Result<Medias>>
    fun getTvSeriesDetail(id: Long): Flow<Result<TvSeriesDetail>>
    fun getTvSeriesVideos(id: Long): Flow<Result<Videos>>
    fun getTvSeriesSeasonDetail(id: Long, seasonNumber: Int): Flow<Result<SeasonDetail>>
    fun getCredits(type: MediaType, id: Long): Flow<Result<Credits>>
    fun getReviews(type: MediaType, id: Long): Flow<Result<Reviews>>
    fun getSimilar(type: MediaType, id: Long): Flow<Result<Medias>>
    fun getPeopleDetail(id: Long): Flow<Result<People>>
    fun getPeopleCredit(id: Long): Flow<Result<Medias>>
}