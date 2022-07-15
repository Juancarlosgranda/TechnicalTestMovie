package com.jc.app.technical.di.module

import com.jc.app.technical.data.source.local.ds.MovieLocalDataSource
import com.jc.app.technical.data.source.local.ds.MovieLocalDataSourceImpl
import com.jc.app.technical.data.source.remote.ds.MovieRemoteDataSource
import com.jc.app.technical.data.source.remote.ds.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun provideMovieRemoteDataSource(
        movieRemoteDataSource: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

    @Binds
    abstract fun provideMovieLocalDataSource(
        movieLocalDataSource: MovieLocalDataSourceImpl
    ): MovieLocalDataSource

}