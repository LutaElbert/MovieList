package com.personal.movielist.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.personal.movielist.R
import com.personal.movielist.databinding.FragmentHomeBinding
import com.personal.movielist.ui.home.adapter.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val mViewModel: HomeViewModel by hiltNavGraphViewModels(R.id.navigation_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecycler(binding)

        return binding.root
    }

    private fun setupRecycler(binding: FragmentHomeBinding) {

        mViewModel.getPopularMovies { list ->
            Log.d("TAG", "onCreateView: $list")
            binding.apply {
                val adapter = MovieListAdapter().also {
                    it.movieList = list
                }
                recycler.adapter =adapter
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}