package com.jc.app.technical.di.component

import com.jc.app.technical.TechnicalApplication
import com.jc.app.technical.di.module.AppModule
import com.jc.app.technical.di.module.FeaturesModule
import com.jc.app.technical.di.module.LocalDataBaseModule
import com.jc.app.technical.di.module.NetworkModule
import com.jc.app.technical.di.module.RepositoryModule
import com.jc.app.technical.di.module.ViewModelKeyModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,  // provide singleton app context
    ViewModelKeyModule::class,  // view model factory.
    LocalDataBaseModule::class, // Room
    NetworkModule::class, // retrofit
    RepositoryModule::class, // Singletons Repositories
    FeaturesModule::class
])
interface AppComponent : AndroidInjector<TechnicalApplication>{

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TechnicalApplication>

}