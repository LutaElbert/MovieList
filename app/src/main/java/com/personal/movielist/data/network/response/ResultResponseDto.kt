package com.personal.movielist.data.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultResponseDto(
    val results: List<MovieResponseDto>
)