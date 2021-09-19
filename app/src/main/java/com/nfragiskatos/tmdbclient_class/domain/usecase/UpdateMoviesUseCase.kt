package com.nfragiskatos.tmdbclient_class.domain.usecase

import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie
import com.nfragiskatos.tmdbclient_class.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}