package com.jc.app.technical.di.module

import com.jc.app.technical.data.repository.MovieRepositoryImpl
import com.jc.app.technical.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

}