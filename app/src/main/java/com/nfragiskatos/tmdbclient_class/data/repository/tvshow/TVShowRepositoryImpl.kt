package com.nfragiskatos.tmdbclient_class.data.repository.tvshow

import android.util.Log
import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.nfragiskatos.tmdbclient_class.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.nfragiskatos.tmdbclient_class.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource, private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                tvShows = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return tvShows
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            tvShows = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShows.isNotEmpty()) {
            return tvShows
        } else {
            tvShows = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShows)
        }

        return tvShows
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            tvShows = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShows.isNotEmpty()) {
            return tvShows
        } else {
            tvShows = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShows)
        }

        return tvShows
    }
}