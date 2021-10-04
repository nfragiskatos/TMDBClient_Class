package com.nfragiskatos.tmdbclient_class.presentation.di.artist

import com.nfragiskatos.tmdbclient_class.domain.usecase.GetArtistsUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateArtistsUseCase
import com.nfragiskatos.tmdbclient_class.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @Provides
    @ArtistScope
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}