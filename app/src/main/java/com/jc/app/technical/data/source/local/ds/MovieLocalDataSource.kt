package com.jc.app.technical.data.source.local.ds

import com.jc.app.technical.data.source.local.entity.MovieEntity

interface MovieLocalDataSource {

    suspend fun getMovies(): List<MovieEntity>

    suspend fun saveAllMovies(movieEntityList: List<MovieEntity>)

}