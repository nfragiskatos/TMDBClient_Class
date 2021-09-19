package com.nfragiskatos.tmdbclient_class.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tv_shows")
data class TVShow(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?,
)