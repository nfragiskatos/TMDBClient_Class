package com.nfragiskatos.tmdbclient_class.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nfragiskatos.tmdbclient_class.domain.usecase.GetTVShowsUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel() {

    fun getTVShows() = liveData {
        val tvShows = getTVShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTVShows() = liveData {
        val tvShows = updateTVShowsUseCase.execute()
        emit(tvShows)
    }
}