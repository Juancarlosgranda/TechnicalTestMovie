package com.jc.app.technical.data.source.remote.ds

import com.jc.app.technical.data.source.remote.response.MovieListResponse
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure

interface MovieRemoteDataSource {

    suspend fun getMovies(): Either<Failure, MovieListResponse>

}