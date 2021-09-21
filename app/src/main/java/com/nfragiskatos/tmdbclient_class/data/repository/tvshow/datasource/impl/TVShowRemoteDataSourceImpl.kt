package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl

import com.nfragiskatos.tmdbclient_class.BuildConfig
import com.nfragiskatos.tmdbclient_class.data.api.TMDBService
import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShows
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(private val service: TMDBService) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShows> = service.getPopularTVShows(BuildConfig.THEMOVIEDB_API_KEY)
}