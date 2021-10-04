package com.nfragiskatos.tmdbclient_class.presentation.di.core

import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl.ArtistCacheDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.impl.MovieCacheDataSourceImpl
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}