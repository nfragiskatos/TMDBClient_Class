package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl

import com.nfragiskatos.tmdbclient_class.data.db.ArtistDao
import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}