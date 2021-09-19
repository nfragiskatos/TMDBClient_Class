package com.nfragiskatos.tmdbclient_class.data


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("results")
    val movies: List<Movie>
)