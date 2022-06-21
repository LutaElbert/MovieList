package com.personal.movielist.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.personal.movielist.data.domain.model.MovieResponseModel
import com.personal.movielist.databinding.ItemMovieBinding

class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    var movieList = listOf<MovieResponseModel>()
        set(value) {
            val todoDiffUtil = MovieDiffUtil(field, value)
            val todoDiffResult = DiffUtil.calculateDiff(todoDiffUtil)
            field = value
            todoDiffResult.dispatchUpdatesTo(this)
        }

    inner class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun init(movieResponseModel: MovieResponseModel) {
            binding.apply {
                item = movieResponseModel

                textTitle.text = movieResponseModel.originalTitle
                textOverview.text = movieResponseModel.overview
                textVoteAve.text = movieResponseModel.voteAverage.toString()
                textReleaseDate.text = movieResponseModel.releaseDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}