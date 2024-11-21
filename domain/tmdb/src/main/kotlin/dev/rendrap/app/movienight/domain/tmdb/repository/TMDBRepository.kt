package dev.rendrap.app.movienight.domain.tmdb.repository

import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.model.Credits
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail
import dev.rendrap.app.movienight.model.People
import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.model.Reviews
import dev.rendrap.app.movienight.model.SeasonDetail
import dev.rendrap.app.movienight.model.TvSeriesDetail
import dev.rendrap.app.movienight.model.Videos
import kotlinx.coroutines.flow.Flow

interface TMDBRepository {
    fun getMovies(param: MovieParameter): Flow<dev.rendrap.app.movienight.core.common.Result<Medias>>
    fun getMovieDetail(id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<MovieDetail>>
    fun getTrending(param: TrendingParameter): Flow<dev.rendrap.app.movienight.core.common.Result<Medias>>
    fun getTvSeries(param: TvParameter): Flow<dev.rendrap.app.movienight.core.common.Result<Medias>>
    fun getTvSeriesDetail(id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<TvSeriesDetail>>
    fun getTvSeriesSeasonDetail(id: Long, seasonNumber: Int): Flow<dev.rendrap.app.movienight.core.common.Result<SeasonDetail>>
    fun getCredits(type: MediaType, id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<Credits>>
    fun getReviews(type: MediaType, id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<Reviews>>
    fun getSimilar(type: MediaType, id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<Medias>>
    fun getVideos(type: MediaType, id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<Videos>>
    fun getPeopleDetail(id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<People>>
    fun getPeopleCredit(id: Long): Flow<dev.rendrap.app.movienight.core.common.Result<Medias>>
}