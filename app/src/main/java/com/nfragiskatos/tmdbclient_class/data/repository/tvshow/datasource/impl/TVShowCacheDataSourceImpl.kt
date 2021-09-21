package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {

    private var tvShows = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShows
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        this.tvShows.clear()
        this.tvShows = ArrayList(tvShows)
    }
}