package com.nfragiskatos.tmdbclient_class.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nfragiskatos.tmdbclient_class.domain.usecase.GetArtistsUseCase
import com.nfragiskatos.tmdbclient_class.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {
    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }
}