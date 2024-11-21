package dev.rendrap.app.movienight.data.tmdb.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.common.extension.pairOf
import dev.rendrap.app.movienight.core.network.KtorClient
import dev.rendrap.app.movienight.data.tmdb.BuildConfig
import dev.rendrap.app.movienight.data.tmdb.utils.TMDBApiConstant.API_KEY
import io.ktor.client.HttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class TMDBApiScope

@Module
@InstallIn(SingletonComponent::class)
internal object TMDBDataModule {
    @Provides
    @Singleton
    @TMDBApiScope
    fun provideTMDBRemoteApi(
        chuckerInterceptor: ChuckerInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): HttpClient = KtorClient
        .Builder()
        .setBaseUrl(BuildConfig.TMDB_URL)
        .addApiKey(pairOf(API_KEY, BuildConfig.TMBD_API_KEY))
        .addInterceptors(chuckerInterceptor, loggingInterceptor)
        .build()
}