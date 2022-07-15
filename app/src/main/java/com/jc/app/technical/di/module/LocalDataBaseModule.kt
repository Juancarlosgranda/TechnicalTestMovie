package com.jc.app.technical.di.module

import android.content.Context
import androidx.room.Room
import com.jc.app.technical.data.source.local.MovieDataBase
import com.jc.app.technical.data.source.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataBaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(appContext: Context): MovieDataBase {
        return Room
            .databaseBuilder(appContext, MovieDataBase::class.java, MovieDataBase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(dataBase: MovieDataBase): MovieDao {
        return dataBase.getMovieDao()
    }

}