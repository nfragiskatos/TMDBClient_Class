package com.nfragiskatos.tmdbclient_class.domain.repository

import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow

interface TVShowRepository {

    suspend fun getTVShows() : List<TVShow>?

    suspend fun updateTVShows() : List<TVShow>?
}