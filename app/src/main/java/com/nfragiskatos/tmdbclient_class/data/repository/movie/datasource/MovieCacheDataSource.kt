package com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}