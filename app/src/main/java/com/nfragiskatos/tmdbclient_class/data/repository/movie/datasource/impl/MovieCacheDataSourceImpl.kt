package com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.impl

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movies = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movies
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        this.movies.clear()
        this.movies = ArrayList(movies)
    }
}