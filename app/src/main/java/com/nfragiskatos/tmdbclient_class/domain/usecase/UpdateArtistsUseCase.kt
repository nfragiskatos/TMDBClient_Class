package com.nfragiskatos.tmdbclient_class.domain.usecase

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist
import com.nfragiskatos.tmdbclient_class.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}