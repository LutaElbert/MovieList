package com.personal.movielist.di

import com.personal.movielist.data.network.service.MovieService
import com.personal.movielist.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesMovieRepository(service: MovieService): MovieRepositoryImpl {
        return MovieRepositoryImpl(service)
    }
}