package com.nfragiskatos.tmdbclient_class.presentation.di.core

import android.content.Context
import com.nfragiskatos.tmdbclient_class.presentation.di.artist.ArtistSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.movie.MovieSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ArtistSubComponent::class, MovieSubComponent::class, TVShowSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}