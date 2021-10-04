package com.nfragiskatos.tmdbclient_class.presentation.di.core

import com.nfragiskatos.tmdbclient_class.data.db.ArtistDao
import com.nfragiskatos.tmdbclient_class.data.db.MovieDao
import com.nfragiskatos.tmdbclient_class.data.db.TVShowDao
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl.ArtistLocalDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.impl.MovieLocalDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Provides
    @Singleton
    fun provideSvShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}