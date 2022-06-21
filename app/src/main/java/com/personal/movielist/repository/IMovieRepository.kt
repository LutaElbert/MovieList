package com.personal.movielist.repository

import com.personal.movielist.data.network.response.ResultResponseDto

interface IMovieRepository {

    suspend fun get(description: String, apiKey: String): ResultResponseDto

}