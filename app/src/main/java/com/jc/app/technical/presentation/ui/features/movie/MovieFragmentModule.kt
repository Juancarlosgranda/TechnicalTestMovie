package com.jc.app.technical.presentation.ui.features.movie

import androidx.lifecycle.ViewModel
import com.jc.app.technical.di.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MovieFragmentModule {
    @ContributesAndroidInjector
    abstract fun bindMovieListFragment(): MovieListFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(
        movieListViewModel: MovieListViewModel
    ): ViewModel
}