package com.nfragiskatos.tmdbclient_class.presentation.di.core

import com.nfragiskatos.tmdbclient_class.data.api.TMDBService
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl.ArtistRemoteDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.impl.MovieRemoteDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @Provides
    @Singleton
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbService)
    }

    @Provides
    @Singleton
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService)
    }
}