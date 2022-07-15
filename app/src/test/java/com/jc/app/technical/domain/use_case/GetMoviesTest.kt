package com.jc.app.technical.domain.use_case

import com.jc.app.technical.data.object_mother.MovieModelObjectMother
import com.jc.app.technical.data.utils.ConnectionUtils
import com.jc.app.technical.domain.model.MovieModel
import com.jc.app.technical.domain.repository.MovieRepository
import com.jc.app.technical.domain.utils.Either
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetMoviesTest {

    private lateinit var getMovies: GetMovies
    private val connectionUtils = mockk<ConnectionUtils> {
        every { isNetworkAvailable() } returns true
    }
    private var mockkRepository: MovieRepository = mockk(relaxed = true)

    @Before
    fun setUp() {
        getMovies = GetMovies(mockkRepository, connectionUtils)
    }

    @Test
    fun `Given movieModelList when use case is called then the result must be the expected value`() {
        val movieModelList: List<MovieModel> = MovieModelObjectMother.provideMovieModelList()

        coEvery {
            mockkRepository.getMoviesFromRemote()
        } returns Either.Success(movieModelList)

        runBlocking {
            getMovies.invoke().either(
                fnL = { Assert.fail() },
                fnR = {
                    Assert.assertTrue(movieModelList == it)
                }
            )
        }
    }


    @Test
    fun `Given isNetworkAvailable with value true when use case is called then getMoviesFromRemote must be called once by repository`() {
        val movieModelList: List<MovieModel> = MovieModelObjectMother.provideMovieModelList()

        coEvery {
            connectionUtils.isNetworkAvailable()
        } returns true

        coEvery {
            mockkRepository.getMoviesFromRemote()
        } returns Either.Success(movieModelList)

        runBlocking {
            getMovies.invoke()
        }
        coVerify(exactly = 1) { mockkRepository.getMoviesFromRemote() }
    }

    @Test
    fun `Given isNetworkAvailable with value false when use case is called then getMoviesFromRemote must be called once by repository`() {
        val movieModelList: List<MovieModel> = MovieModelObjectMother.provideMovieModelList()

        coEvery {
            connectionUtils.isNetworkAvailable()
        } returns false

        coEvery {
            mockkRepository.getMoviesFromLocal()
        } returns movieModelList

        runBlocking {
            getMovies.invoke()
        }
        coVerify(exactly = 1) { mockkRepository.getMoviesFromLocal() }
    }
}