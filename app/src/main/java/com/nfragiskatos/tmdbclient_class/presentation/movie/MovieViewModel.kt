package com.nfragiskatos.tmdbclient_class.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nfragiskatos.tmdbclient_class.domain.usecase.GetMoviesUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movies = getMoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }
}