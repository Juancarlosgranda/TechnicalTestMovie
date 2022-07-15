package com.jc.app.technical.di.module

import android.content.Context
import com.jc.app.technical.TechnicalApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: TechnicalApplication): Context {
        return app.applicationContext
    }
}