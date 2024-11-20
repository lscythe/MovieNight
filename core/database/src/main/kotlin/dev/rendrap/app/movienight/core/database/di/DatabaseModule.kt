package dev.rendrap.app.movienight.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.database.MovieNightDatabase
import dev.rendrap.app.movienight.core.database.MovieNightDatabase.Companion.DATABASE_NAME
import dev.rendrap.app.movienight.core.database.utils.PassphraseProvider
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideSupportFactory(
        passphraseProvider: PassphraseProvider
    ): SupportOpenHelperFactory = SupportOpenHelperFactory(passphraseProvider.get())

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        factory: SupportOpenHelperFactory
    ): MovieNightDatabase {
        System.loadLibrary("sqlcipher")
        return Room
            .databaseBuilder(
                context,
                MovieNightDatabase::class.java,
                DATABASE_NAME
            )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }
}