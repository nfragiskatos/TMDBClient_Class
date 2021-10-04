package com.nfragiskatos.tmdbclient_class.presentation.di.core

import com.nfragiskatos.tmdbclient_class.data.repository.artist.ArtistRepositoryImpl
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.MovieRepositoryImpl
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.TVShowRepositoryImpl
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.nfragiskatos.tmdbclient_class.domain.repository.ArtistRepository
import com.nfragiskatos.tmdbclient_class.domain.repository.MovieRepository
import com.nfragiskatos.tmdbclient_class.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}