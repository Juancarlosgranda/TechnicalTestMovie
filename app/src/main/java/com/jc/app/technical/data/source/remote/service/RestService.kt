package com.jc.app.technical.data.source.remote.service

import com.jc.app.technical.data.source.remote.response.MovieListResponse
import retrofit2.Response
import retrofit2.http.*

interface RestService {

    @GET("3/movie/popular?api_key=09963e300150f9831c46a1828a82a984&language=en-US")
    suspend fun getMovies(): Response<MovieListResponse>
}