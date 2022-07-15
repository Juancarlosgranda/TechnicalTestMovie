/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val safeArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}" }
}

/**
 * To define dependencies
 */
object Dependencies {
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val navigation by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.safeArgs}" }

    val activity by lazy { "androidx.activity:activity-ktx:${Versions.activity}" }
    val fragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.fragment}" }
    val runtime by lazy { "androidx.work:work-runtime-ktx:${Versions.androidRuntime}" }

    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit2}" }
    val retrofit2Converter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}" }
    val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}" }
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val dagger by lazy { "com.google.dagger:dagger:${Versions.dagger}" }
    val daggerCompiler by lazy { "com.google.dagger:dagger-compiler:${Versions.dagger}" }
    val daggerAndroid by lazy { "com.google.dagger:dagger-android:${Versions.dagger}" }
    val daggerSupport by lazy { "com.google.dagger:dagger-android-support:${Versions.dagger}" }
    val daggerProcessor by lazy { "com.google.dagger:dagger-android-processor:${Versions.dagger}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val room by lazy { "androidx.room:room-ktx:${Versions.room}" }
    val coil by lazy { "io.coil-kt:coil:${Versions.coil}" }
}

object DependenciesTest {
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}" }

    val junitAndroid by lazy { "androidx.test.ext:junit:${Versions.jUnitAndroid}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }

}