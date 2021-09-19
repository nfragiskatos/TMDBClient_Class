package com.nfragiskatos.tmdbclient_class.domain.usecase

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow
import com.nfragiskatos.tmdbclient_class.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.getTVShows()
}