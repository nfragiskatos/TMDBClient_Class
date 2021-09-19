package com.nfragiskatos.tmdbclient_class.domain.repository

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}