package com.jc.app.technical.di.module

import com.jc.app.technical.presentation.ui.features.FeatureMainModule
import dagger.Module

@Module(includes = [
    FeatureMainModule::class,
])
abstract class FeaturesModule