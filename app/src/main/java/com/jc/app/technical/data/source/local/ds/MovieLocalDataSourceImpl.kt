package com.jc.app.technical.data.source.local.ds

import com.jc.app.technical.data.source.local.dao.MovieDao
import com.jc.app.technical.data.source.local.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val dao: MovieDao
): MovieLocalDataSource {

    override suspend fun getMovies(): List<MovieEntity> = dao.getMovies()

    override suspend fun saveAllMovies(
        movieEntityList: List<MovieEntity>
    ) = dao.insertAll(movieEntityList)
}