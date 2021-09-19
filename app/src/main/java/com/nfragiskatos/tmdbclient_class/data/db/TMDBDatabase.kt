package com.nfragiskatos.tmdbclient_class.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nfragiskatos.tmdbclient_class.data.model.artist.Artist
import com.nfragiskatos.tmdbclient_class.data.model.movie.Movie
import com.nfragiskatos.tmdbclient_class.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    abstract fun tvShowDao() : TVShowDao

    abstract fun artistDao() : ArtistDao
}