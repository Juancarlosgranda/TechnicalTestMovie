package com.jc.app.technical.data.source.local.dao

import androidx.room.*
import com.jc.app.technical.data.source.local.base.BaseDao
import com.jc.app.technical.data.source.local.entity.MovieEntity

@Dao
interface MovieDao : BaseDao<MovieEntity> {

    @Query("SELECT * from MovieEntity")
    suspend fun getMovies(): List<MovieEntity>

    @Query("DELETE FROM MovieEntity")
    suspend fun deleteAll()

}