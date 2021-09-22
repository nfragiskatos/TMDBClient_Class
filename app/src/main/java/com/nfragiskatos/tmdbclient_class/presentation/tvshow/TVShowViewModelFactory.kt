package com.nfragiskatos.tmdbclient_class.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nfragiskatos.tmdbclient_class.domain.usecase.GetTVShowsUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}