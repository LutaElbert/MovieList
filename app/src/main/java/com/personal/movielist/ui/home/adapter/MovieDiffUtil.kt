package com.personal.movielist.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.personal.movielist.data.domain.model.MovieResponseModel

class MovieDiffUtil(val oldList: List<MovieResponseModel>, val newList: List<MovieResponseModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}