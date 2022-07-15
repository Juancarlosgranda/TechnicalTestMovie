package com.jc.app.technical.domain.repository

import com.jc.app.technical.data.object_mother.MovieEntityObjectMother
import com.jc.app.technical.data.object_mother.MovieModelObjectMother
import com.jc.app.technical.data.object_mother.MovieResponseObjectMother
import com.jc.app.technical.data.repository.MovieRepositoryImpl
import com.jc.app.technical.data.source.local.dao.MovieDao
import com.jc.app.technical.data.source.local.ds.MovieLocalDataSource
import com.jc.app.technical.data.source.local.ds.MovieLocalDataSourceImpl
import com.jc.app.technical.data.source.local.entity.MovieEntity
import com.jc.app.technical.data.source.remote.ds.MovieRemoteDataSource
import com.jc.app.technical.data.source.remote.ds.MovieRemoteDataSourceImpl
import com.jc.app.technical.data.source.remote.response.MovieListResponse
import com.jc.app.technical.data.source.remote.service.RestService
import com.jc.app.technical.data.utils.ConnectionUtils
import com.jc.app.technical.domain.model.MovieModel
import com.jc.app.technical.domain.utils.Either
import com.jc.app.technical.domain.utils.Failure
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class MovieRepositoryTest {

    private val restService = mockk<RestService>()
    private val movieDao = mockk<MovieDao> (relaxed = true)
    private val connectionUtils = mockk<ConnectionUtils> {
        every { isNetworkAvailable() } returns true
    }
    private val remoteDataSource: MovieRemoteDataSource = MovieRemoteDataSourceImpl(
        restService = restService,
        connectionUtils = connectionUtils
    )
    private val localDataSource: MovieLocalDataSource = MovieLocalDataSourceImpl(
        dao = movieDao
    )

    private val repository: MovieRepository = MovieRepositoryImpl(
        remoteDS = remoteDataSource,
        localDS = localDataSource
    )

    private var movieListResponse: MovieListResponse =
        MovieResponseObjectMother.provideRemoteMoviesFromAssets()

    @Before
    fun setUp() {
        coEvery {
            restService.getMovies()
        } returns Response.success(movieListResponse)
    }


    @Test
    fun `Given data sources when getMovies is called then saveAllMovies must call one time`() {
        val movieModelList: List<MovieModel> = MovieModelObjectMother.provideMovieModelList()

        runBlocking {
            repository.getMoviesFromRemote()
        }
        coVerify(exactly = 1) { repository.saveAllMovies(movieModelList) }
    }

    @Test
    fun `Given data sources when getMovies is called then the result must be successful and the same size as the movieListResponse`() {
        runBlocking {
            val res: Either<Failure, List<MovieModel>> = repository.getMoviesFromRemote()
            coVerify(exactly = 1) { repository.getMoviesFromRemote() }
            res.either(
                fnL = {
                    Assert.fail()
                },
                fnR = {
                    assertTrue(it.size == movieListResponse.results.size)
                }
            )
        }
    }

    @Test
    fun `Given movieEntityList when getMoviesFromLocal is called then the result  must be the same size as the movieEntityList`() {
        val movieEntityList: List<MovieEntity> = MovieEntityObjectMother.provideMovieEntityList()

        coEvery {
            localDataSource.getMovies()
        } returns movieEntityList

        runBlocking {
            val res = repository.getMoviesFromLocal()
            assertTrue(res.size == movieEntityList.size)
        }
    }

    @Test
    fun `Given movieModelList when saveAllMovies is called then the result must works as expected`() {
        val movieModelList: List<MovieModel> = MovieModelObjectMother.provideMovieModelList()

        runBlocking {
            val res = repository.saveAllMovies(movieModelList)
            coVerify (exactly = 1){ localDataSource.saveAllMovies(any())}
            assertTrue(res == Unit)
        }
    }

    @Test
    fun `Given errorBody when getMoviesFromRemote is called then the it must returns network service call exception properly`() {
        val errorBody = "{\"error\": \"Invalid Request\",\"status_code\": 404}"
            .toResponseBody("application/json".toMediaTypeOrNull())

        coEvery {
            restService.getMovies()
        } throws HttpException(Response.error<Any>(404, errorBody))

        lateinit var res: Either<Failure, List<MovieModel>>

        runBlocking {
            res = repository.getMoviesFromRemote()
        }
        assertTrue(res.isError)
    }

}