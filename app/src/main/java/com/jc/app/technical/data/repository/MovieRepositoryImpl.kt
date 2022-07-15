package com.jc.app.technical.data.repository

import com.jc.app.technical.data.source.local.ds.MovieLocalDataSource
import com.jc.app.technical.data.source.local.entity.MovieEntity
import com.jc.app.technical.data.source.remote.ds.MovieRemoteDataSource
import com.jc.app.technical.domain.model.MovieModel
import com.jc.app.technical.domain.repository.MovieRepository
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDS: MovieRemoteDataSource,
    private val localDS: MovieLocalDataSource
) : MovieRepository {

    override suspend fun getMoviesFromRemote(): Either<Failure, List<MovieModel>> {
        return remoteDS.getMovies().coMapSuccess { response ->
            response.results.map { it.toMovieModel() }.apply { saveAllMovies(this) }
        }
    }

    override suspend fun getMoviesFromLocal(): List<MovieModel> {
        return localDS.getMovies().map { it.toMovieModel() }
    }

    override suspend fun saveAllMovies(movieModelList: List<MovieModel>) {
        localDS.saveAllMovies(
            movieModelList.map {
                MovieEntity(
                    it.id,
                    it.title,
                    it.description,
                    it.voteCount,
                    it.releaseDate,
                    it.popularity,
                    it.urlImage
                )
            }
        )
    }
}