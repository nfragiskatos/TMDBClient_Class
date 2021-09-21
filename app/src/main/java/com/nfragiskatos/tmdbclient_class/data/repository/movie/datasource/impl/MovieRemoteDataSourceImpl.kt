package com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.impl

import com.nfragiskatos.tmdbclient_class.BuildConfig
import com.nfragiskatos.tmdbclient_class.data.api.TMDBService
import com.nfragiskatos.tmdbclient_class.data.model.movie.Movies
import com.nfragiskatos.tmdbclient_class.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val service: TMDBService) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<Movies> = service.getPopularMovies(BuildConfig.THEMOVIEDB_API_KEY)
}