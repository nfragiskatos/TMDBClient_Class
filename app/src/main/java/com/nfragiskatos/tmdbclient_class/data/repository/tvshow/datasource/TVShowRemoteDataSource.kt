package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShows
import retrofit2.Response

interface TVShowRemoteDataSource {

    suspend fun getTVShows(): Response<TVShows>

}