package com.jc.app.technical.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jc.app.technical.data.source.local.dao.MovieDao
import com.jc.app.technical.data.source.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDataBase : RoomDatabase()  {

    abstract fun getMovieDao(): MovieDao

    companion object {
        const val DATABASE_NAME = "movie_db"
    }
}