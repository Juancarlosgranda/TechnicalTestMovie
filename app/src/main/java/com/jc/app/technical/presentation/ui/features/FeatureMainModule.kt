package com.jc.app.technical.presentation.ui.features

import com.jc.app.technical.di.scopes.PerActivityScope
import com.jc.app.technical.presentation.ui.MainActivity
import com.jc.app.technical.presentation.ui.features.movie.MovieFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeatureMainModule {

    @PerActivityScope
    @ContributesAndroidInjector(modules = [
        MovieFragmentModule::class,
    ])
    abstract fun bindMainActivity(): MainActivity

}