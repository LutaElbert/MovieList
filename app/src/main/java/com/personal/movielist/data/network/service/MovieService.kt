package com.personal.movielist.data.network.service

import com.personal.movielist.data.network.response.ResultResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie")
    suspend fun getPopularMovies(
        @Query("sort_by")
        description:String,
        @Query("api_key")
        apiKey: String
    ): ResultResponseDto

}