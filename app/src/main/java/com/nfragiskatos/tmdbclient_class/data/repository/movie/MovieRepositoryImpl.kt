package com.nfragiskatos.tmdbclient_class.data.repository.movie

import android.util.Log
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieRemoteDataSource
import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie
import com.nfragiskatos.tmdbclient_class.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>?  = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovies)
        movieCacheDataSource.saveMoviesToCache(newMovies)
        return newMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movies = body.movies
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return movies
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movies: List<Movie>

        try {
            movies = movieLocalDataSource.getMoviesFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movies)
        }

        return movies
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movies: List<Movie>

        try {
            movies = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movies)
        }

        return movies
    }
}