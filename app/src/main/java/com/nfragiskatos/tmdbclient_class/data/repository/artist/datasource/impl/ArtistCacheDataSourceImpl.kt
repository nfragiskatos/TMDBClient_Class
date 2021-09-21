package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artists = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artists
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        this.artists.clear()
        this.artists = ArrayList(artists)
    }
}