package com.nfragiskatos.tmdbclient_class.presentation

import android.app.Application
import com.nfragiskatos.tmdbclient_class.BuildConfig
import com.nfragiskatos.tmdbclient_class.presentation.di.Injector
import com.nfragiskatos.tmdbclient_class.presentation.di.artist.ArtistSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.core.*
import com.nfragiskatos.tmdbclient_class.presentation.di.movie.MovieSubComponent
import com.nfragiskatos.tmdbclient_class.presentation.di.tvshow.TVShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule()).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}