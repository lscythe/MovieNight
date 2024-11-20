package dev.rendrap.app.movienight.core.network.di

import android.content.Context
import coil.ImageLoader
import coil.util.DebugLogger
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.MAX_CHUCKER_CONTENT_LENGTH
import dev.rendrap.app.movienight.network.BuildConfig
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Provides
    @Singleton
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context,
    ): ChuckerInterceptor = ChuckerInterceptor
        .Builder(context)
        .collector(ChuckerCollector(context))
        .maxContentLength(MAX_CHUCKER_CONTENT_LENGTH)
        .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    fun provideOkHttpCallFactory(
        loggingInterceptor: HttpLoggingInterceptor,
    ): Call.Factory = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideCoilImageLoader(
        @ApplicationContext context: Context,
        callFactory: Call.Factory,
    ): ImageLoader = ImageLoader
        .Builder(context)
        .callFactory(callFactory)
        .apply {
            if (BuildConfig.DEBUG) logger(DebugLogger())
        }
        .build()
}