package com.nfragiskatos.tmdbclient_class.presentation.di.core

import com.nfragiskatos.tmdbclient_class.domain.repository.ArtistRepository
import com.nfragiskatos.tmdbclient_class.domain.repository.MovieRepository
import com.nfragiskatos.tmdbclient_class.domain.repository.TVShowRepository
import com.nfragiskatos.tmdbclient_class.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}