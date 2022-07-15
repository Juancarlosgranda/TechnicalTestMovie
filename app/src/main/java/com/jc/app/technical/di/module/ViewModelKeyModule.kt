package com.jc.app.technical.di.module

import androidx.lifecycle.ViewModelProvider
import com.jc.app.technical.di.vm.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelKeyModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}