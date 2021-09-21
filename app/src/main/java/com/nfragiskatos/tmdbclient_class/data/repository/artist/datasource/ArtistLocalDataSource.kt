package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB() : List<Artist>

    suspend fun saveArtistsToDB(artists: List<Artist>)

    suspend fun clearAll()
}