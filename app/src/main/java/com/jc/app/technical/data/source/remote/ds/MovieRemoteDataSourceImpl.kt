package com.jc.app.technical.data.source.remote.ds

import com.jc.app.technical.data.source.remote.response.MovieListResponse
import com.jc.app.technical.data.source.remote.service.RestService
import com.jc.app.technical.data.utils.CallServiceBase
import com.jc.app.technical.data.utils.ConnectionUtils
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val restService: RestService,
    private val connectionUtils: ConnectionUtils
) : MovieRemoteDataSource, CallServiceBase()  {

    override fun getNetworkUtils() = connectionUtils

    override suspend fun getMovies(): Either<Failure, MovieListResponse> = callService {
        restService.getMovies()
    }

}