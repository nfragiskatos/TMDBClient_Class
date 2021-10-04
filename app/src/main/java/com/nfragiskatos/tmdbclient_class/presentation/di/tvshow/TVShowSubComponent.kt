package com.nfragiskatos.tmdbclient_class.presentation.di.tvshow

import com.nfragiskatos.tmdbclient_class.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {

    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}