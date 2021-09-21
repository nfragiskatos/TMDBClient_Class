package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource

import com.nfragiskatos.tmdbclient_class.data.model.artist.Artists
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<Artists>
}