package com.nfragiskatos.tmdbclient_class.domain.usecase

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow
import com.nfragiskatos.tmdbclient_class.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvShowRepository.updateTVShows()
}