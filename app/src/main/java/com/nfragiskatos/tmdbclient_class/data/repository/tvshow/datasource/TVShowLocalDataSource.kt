package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow

interface TVShowLocalDataSource {

    suspend fun getTVShowsFromDB(): List<TVShow>

    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)

    suspend fun clearAll()
}