package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>

    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)
}