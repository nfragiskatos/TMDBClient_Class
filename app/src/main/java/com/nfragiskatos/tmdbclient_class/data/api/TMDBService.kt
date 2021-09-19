package com.nfragiskatos.tmdbclient_class.data.api

import com.nfragiskatos.tmdbclient_class.data.Artists
import com.nfragiskatos.tmdbclient_class.data.Movies
import com.nfragiskatos.tmdbclient_class.data.TVShows
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String) : Response<Movies>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String) : Response<TVShows>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String) : Response<Artists>
}