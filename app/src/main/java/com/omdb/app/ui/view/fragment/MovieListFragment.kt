package com.omdb.app.ui.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.omdb.app.R
import com.omdb.app.core.BaseFragment
import com.omdb.app.databinding.FragmentMovieListBinding
import com.omdb.app.ui.adapter.Adapter
import com.omdb.app.ui.adapter.ItemViewModel
import com.omdb.app.ui.adapter.MovieModel
import com.omdb.app.ui.callback.IItemClick
import com.omdb.app.ui.viewmodel.MovieStateEvent
import com.omdb.app.ui.viewmodel.MovieViewModel
import com.omdb.app.utils.ViewState
import com.omdb.app.utils.applyAnimation
import com.omdb.app.utils.isListNotEmpty
import com.omdb.app.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * @Details MovieListFragment:Main fragment where user interact with UI :
 *  1. Fetch the Movie
 *  2.Populate the data on UI
 * @Author Roshan Bhagat
 * @constructor
 */
@AndroidEntryPoint
class MovieListFragment(
    override val layoutId: Int = R.layout.fragment_movie_list
) : BaseFragment<FragmentMovieListBinding>() {

    private val viewModel: MovieViewModel by viewModels()
    private val safeArgs: MovieListFragmentArgs by navArgs()


    @Inject
    lateinit var movieAdapter: Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        if (savedInstanceState == null) {
            fetchMovieList()
        }
    }

    /**
     * Init.
     */
    private fun init() {
        setupRecyclerView()
        subscribeObservers()
        setupListener()
    }


    /**
     * Fetch movie content
     *
     */
    private fun fetchMovieList() {
        /**
         * MVI approach provides more flexibility to perform multiple operation/intent from same state .
         * This way we can remove number of boilerplate code from our repo and easily achieve the asynchronous Programming
         */
        viewModel.setStateIntent(MovieStateEvent.GetMoviesList(safeArgs.searchText))
    }


    /**
     * Setup recycler view.
     */
    private fun setupRecyclerView() {
        binding.rvMoviesList.adapter = movieAdapter

    }

    /**
     * Setup listener.
     */
    private fun setupListener() {
        movieAdapter.callback = object : IItemClick<ItemViewModel> {
            override fun onItemClick(item: ItemViewModel) {
                applyAnimation(NavOptions.Builder())
                val movie: MovieModel = item as MovieModel
                val action = MovieListFragmentDirections.actionSearchFragmentToDetailFragment(movie)
                findNavController().navigate(action)
            }
        }

    }

    /**
     * subscribeObservers is an Observers function for mutable live data
     */
    private fun subscribeObservers() {
        viewModel.viewState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is ViewState.Loading -> {
                    showLoading()
                }
                is ViewState.Success -> {
                    hideLoading()
                    val moviesList: List<MovieModel> = dataState.data as List<MovieModel>
                    if (isListNotEmpty(moviesList)) {
                        movieAdapter.updateItems(moviesList)
                    }
                }
                is ViewState.Failure -> {
                    hideLoading()
                    context?.showToast(getString(R.string.error_msg))

                }
            }
        }
    }


}


