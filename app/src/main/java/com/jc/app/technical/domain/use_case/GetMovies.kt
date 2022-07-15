package com.jc.app.technical.domain.use_case

import com.jc.app.technical.data.utils.ConnectionUtils
import com.jc.app.technical.domain.extensions.toSuccess
import com.jc.app.technical.domain.model.MovieModel
import com.jc.app.technical.domain.repository.MovieRepository
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure
import javax.inject.Inject

class GetMovies @Inject constructor (
    private val repository: MovieRepository,
    private val connectionUtils: ConnectionUtils
) {

    suspend operator fun invoke(): Either<Failure, List<MovieModel>> {
        return if (connectionUtils.isNetworkAvailable()){
            repository.getMoviesFromRemote()
        }else{
            repository.getMoviesFromLocal().toSuccess()
        }
    }

}