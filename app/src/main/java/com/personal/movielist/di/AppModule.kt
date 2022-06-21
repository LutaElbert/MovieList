package com.personal.movielist.di

import android.content.Context
import com.personal.movielist.BaseApplication
import com.personal.movielist.data.network.mapper.MovieEntityMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseApplication(@ApplicationContext context: Context): BaseApplication {
        return context as BaseApplication
    }

    @Provides
    @Named("baseUrl")
    fun providesBaseUrl() = "https://api.themoviedb.org/3/discover/"

    @Provides
    @Named("apiKey")
    fun providesApiKey() = "db7f668dd849ba1e274dcc073947fc98"

    @Provides
    fun provideEntityMapper() = MovieEntityMapperImpl()
}