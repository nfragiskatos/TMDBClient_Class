package com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.impl

import com.nfragiskatos.tmdbclient_class.BuildConfig
import com.nfragiskatos.tmdbclient_class.data.api.TMDBService
import com.nfragiskatos.tmdbclient_class.data.model.artist.Artists
import com.nfragiskatos.tmdbclient_class.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val service: TMDBService) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<Artists> =
        service.getPopularArtists(BuildConfig.THEMOVIEDB_API_KEY)
}