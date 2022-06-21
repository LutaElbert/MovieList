package com.personal.movielist.repository

import com.personal.movielist.data.network.response.MovieResponseDto
import com.personal.movielist.data.network.response.ResultResponseDto
import com.personal.movielist.data.network.service.MovieService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val response: MovieService
): IMovieRepository {
    override suspend fun get(description: String, apiKey: String): ResultResponseDto {
        return response.getPopularMovies(description, apiKey)
    }
}