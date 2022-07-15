plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigApp.compileSdk

    defaultConfig {

        applicationId = "com.jc.app.technical"
        minSdk = ConfigApp.minSdk
        targetSdk = ConfigApp.targetSdk
        versionCode = ConfigApp.versionCode
        versionName = ConfigApp.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BaseURL", "\"https://api.themoviedb.org/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation (Dependencies.activity)
    implementation (Dependencies.fragment)
    implementation (Dependencies.runtime)

    implementation (Dependencies.retrofit2)
    implementation (Dependencies.interceptor)
    implementation (Dependencies.gson)
    implementation (Dependencies.retrofit2Converter)

    implementation (Dependencies.coroutines)
    implementation (Dependencies.coroutinesAndroid)

    implementation(Dependencies.navigation)

    api (Dependencies.dagger)
    kapt (Dependencies.daggerCompiler)
    implementation (Dependencies.daggerAndroid)
    implementation (Dependencies.daggerSupport)
    annotationProcessor (Dependencies.daggerCompiler)
    annotationProcessor (Dependencies.daggerProcessor)
    kapt (Dependencies.daggerProcessor)

    implementation (Dependencies.roomRuntime)
    kapt (Dependencies.roomCompiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation (Dependencies.room)

    implementation (Dependencies.coil)

    testImplementation(DependenciesTest.junit)
    testImplementation(DependenciesTest.mockk)
    testImplementation(DependenciesTest.coroutines)

    androidTestImplementation(DependenciesTest.junitAndroid)
    androidTestImplementation(DependenciesTest.espresso)
}
