package com.nfragiskatos.tmdbclient_class.presentation.di.tvshow

import com.nfragiskatos.tmdbclient_class.domain.usecase.GetTVShowsUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateTVShowsUseCase
import com.nfragiskatos.tmdbclient_class.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @Provides
    @TVShowScope
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowsUseCase, updateTVShowsUseCase)
    }
}