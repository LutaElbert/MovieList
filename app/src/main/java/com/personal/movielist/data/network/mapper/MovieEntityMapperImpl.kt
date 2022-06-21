package com.personal.movielist.data.network.mapper

import com.personal.movielist.data.network.response.MovieResponseDto
import com.personal.movielist.data.domain.model.MovieResponseModel

class MovieEntityMapperImpl: IMovieEntityMapper<MovieResponseDto, MovieResponseModel> {
    override fun mapFromEntity(entity: MovieResponseDto): MovieResponseModel {
        return MovieResponseModel(
            id = entity.id,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            voteAverage = entity.voteAverage
        )
    }

    override fun mapToEntity(domain: MovieResponseModel): MovieResponseDto {
        return MovieResponseDto(
            id = domain.id,
            originalTitle = domain.originalTitle,
            overview = domain.overview,
            posterPath = domain.posterPath,
            releaseDate = domain.releaseDate,
            voteAverage = domain.voteAverage
        )
    }

    fun mapFromEntityList(list: List<MovieResponseDto>) = list.map { mapFromEntity(it) }

    fun mapToEntityList(list: List<MovieResponseModel>) = list.map { mapToEntity(it) }
}