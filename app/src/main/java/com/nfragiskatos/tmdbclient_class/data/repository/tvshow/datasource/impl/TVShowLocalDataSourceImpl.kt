package com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.impl

import com.nfragiskatos.tmdbclient_class.data.db.TVShowDao
import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> = tvShowDao.getTVShows()

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTVShows()
        }
    }
}