package com.personal.movielist.data.network.mapper

interface IMovieEntityMapper<Entity, Domain> {

    fun mapFromEntity(entity: Entity): Domain

    fun mapToEntity(domain: Domain): Entity
}