package com.nfragiskatos.tmdbclient_class.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.nfragiskatos.tmdbclient_class.data.db.ArtistDao
import com.nfragiskatos.tmdbclient_class.data.db.MovieDao
import com.nfragiskatos.tmdbclient_class.data.db.TMDBDatabase
import com.nfragiskatos.tmdbclient_class.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TVShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Provides
    @Singleton
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}