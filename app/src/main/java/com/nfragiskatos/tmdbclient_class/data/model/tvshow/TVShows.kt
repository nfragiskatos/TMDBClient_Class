package com.nfragiskatos.tmdbclient_class.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TVShows(
    @SerializedName("results")
    val tvShows: List<TVShow>,
)