package com.nfragiskatos.tmdbclient_class.data.repository.artist

import android.util.Log
import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nfragiskatos.tmdbclient_class.domain.repository.ArtistRepository


class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtists)
        artistCacheDataSource.saveArtistsToCache(newArtists)
        return newArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artists = body.artists
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return artists
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            artists = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artists.isNotEmpty()) {
            return artists
        } else {
            artists = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artists)
        }

        return artists
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artists.isNotEmpty()) {
            return artists
        } else {
            artists = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artists)
        }

        return artists
    }

}