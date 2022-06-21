package com.personal.movielist.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.movielist.data.domain.model.MovieResponseModel
import com.personal.movielist.data.network.mapper.MovieEntityMapperImpl
import com.personal.movielist.repository.MovieRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepositoryImpl,
    private val mapper: MovieEntityMapperImpl
): ViewModel() {

    @Inject
    @Named("apiKey")
    lateinit var apiKey: String

    fun getPopularMovies(completion: (List<MovieResponseModel>) -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            val mapperList = mapper.mapFromEntityList(
                repository.get("popularity.desc", apiKey).results
            )

            withContext(Dispatchers.Main) {
                completion.invoke(mapperList)
            }
        }
    }

}