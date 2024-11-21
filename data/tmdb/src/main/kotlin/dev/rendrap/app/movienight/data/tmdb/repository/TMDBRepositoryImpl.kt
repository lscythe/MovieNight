package dev.rendrap.app.movienight.data.tmdb.repository

import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.core.common.map
import dev.rendrap.app.movienight.core.network.utils.resultFlow
import dev.rendrap.app.movienight.data.tmdb.datasource.TMDBRemoteDataSource
import dev.rendrap.app.movienight.data.tmdb.mapper.toModel
import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import dev.rendrap.app.movienight.model.Credits
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail
import dev.rendrap.app.movienight.model.People
import dev.rendrap.app.movienight.model.Reviews
import dev.rendrap.app.movienight.model.SeasonDetail
import dev.rendrap.app.movienight.model.TvSeriesDetail
import dev.rendrap.app.movienight.model.Videos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TMDBRepositoryImpl @Inject constructor(
    private val remoteDataSource: TMDBRemoteDataSource
) : TMDBRepository {
    override fun getMovies(param: MovieParameter): Flow<Result<Medias>> = resultFlow {
        remoteDataSource.getMovies(param)
    }.map { it.map { res -> res.toModel() } }

    override fun getMovieDetail(id: Long): Flow<Result<MovieDetail>> = resultFlow {
        remoteDataSource.getMovieDetail(id)
    }.map { it.map { res -> res.toModel() } }

    override fun getTrending(param: TrendingParameter): Flow<Result<Medias>> = resultFlow {
        remoteDataSource.getTrending(param)
    }.map { it.map { res -> res.toModel(param.type) } }

    override fun getTvSeries(param: TvParameter): Flow<Result<Medias>> = resultFlow {
        remoteDataSource.getTvSeries(param)
    }.map { it.map { res -> res.toModel() } }

    override fun getTvSeriesDetail(id: Long): Flow<Result<TvSeriesDetail>> = resultFlow {
        remoteDataSource.getTvSeriesDetail(id)
    }.map { it.map { res -> res.toModel() } }

    override fun getTvSeriesSeasonDetail(
        id: Long, seasonNumber: Int
    ): Flow<Result<SeasonDetail>> = resultFlow {
        remoteDataSource.getTvSeriesSeasonDetail(id, seasonNumber)
    }.map { it.map { res -> res.toModel() } }

    override fun getCredits(type: MediaType, id: Long): Flow<Result<Credits>> = resultFlow {
        remoteDataSource.getCredits(type, id)
    }.map { it.map { res -> res.toModel() } }

    override fun getReviews(type: MediaType, id: Long): Flow<Result<Reviews>> = resultFlow {
        remoteDataSource.getReviews(type, id)
    }.map { it.map { res -> res.toModel() } }

    override fun getSimilar(type: MediaType, id: Long): Flow<Result<Medias>> = resultFlow {
        remoteDataSource.getSimilar(type, id)
    }.map { it.map { res -> res.toModel(type) } }

    override fun getVideos(type: MediaType, id: Long): Flow<Result<Videos>> = resultFlow {
        remoteDataSource.getVideos(type, id)
    }.map { it.map { res -> res.toModel() } }

    override fun getPeopleDetail(id: Long): Flow<Result<People>> = resultFlow {
        remoteDataSource.getPeopleDetail(id)
    }.map { it.map { res -> res.toModel() } }

    override fun getPeopleCredit(id: Long): Flow<Result<Credits>> = resultFlow {
        remoteDataSource.getPeopleCredit(id)
    }.map { it.map { res -> res.toModel() } }

}