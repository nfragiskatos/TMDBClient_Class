package com.nfragiskatos.tmdbclient_class.presentation.di.movie

import com.nfragiskatos.tmdbclient_class.domain.usecase.GetMoviesUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateMoviesUseCase
import com.nfragiskatos.tmdbclient_class.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @Provides
    @MovieScope
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}