package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)

}