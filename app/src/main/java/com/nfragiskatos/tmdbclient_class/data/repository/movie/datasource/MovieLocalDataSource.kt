package com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB() : List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}