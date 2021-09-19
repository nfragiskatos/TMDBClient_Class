package com.nfragiskatos.tmdbclient_class.data


import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("results")
    val artists: List<Artist>,
)