package com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie
import com.nfragiskatos.tmdbclient_class.data.model.movie.Movies
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<Movies>
}