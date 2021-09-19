package com.nfragiskatos.tmdbclient_class.domain.repository

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?
}