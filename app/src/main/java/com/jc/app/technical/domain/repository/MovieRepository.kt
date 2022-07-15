package com.jc.app.technical.domain.repository

import com.jc.app.technical.domain.model.MovieModel
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure

interface MovieRepository {

    suspend fun getMoviesFromRemote(): Either<Failure, List<MovieModel>>

    suspend fun getMoviesFromLocal(): List<MovieModel>

    suspend fun saveAllMovies(movieModelList: List<MovieModel>)

}