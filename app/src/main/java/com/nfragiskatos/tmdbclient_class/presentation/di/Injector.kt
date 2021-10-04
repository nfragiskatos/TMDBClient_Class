package com.nfragiskatos.tmdbclient_class.presentation.di

import com.nfragiskatos.tmdbclient_class.presentation.di.artist.ArtistSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.movie.MovieSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent

    fun createTVShowSubComponent() : TVShowSubComponent

    fun createArtistSubComponent() : ArtistSubComponent
}