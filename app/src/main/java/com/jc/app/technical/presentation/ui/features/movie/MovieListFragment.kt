package com.jc.app.technical.presentation.ui.features.movie

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.jc.app.technical.BR
import com.jc.app.technical.R
import com.jc.app.technical.databinding.FragmentMovieListBinding
import com.jc.app.technical.presentation.adapters.MovieListAdapter
import com.jc.app.technical.presentation.extensions.showToast
import com.jc.app.technical.presentation.ui.base.BaseFragmentWithViewModel

class MovieListFragment : BaseFragmentWithViewModel<FragmentMovieListBinding, MovieListViewModel>() {

    override val getBindingVariable: Int
        get() = BR.movieListVM

    override val getLayoutId: Int
        get() = R.layout.fragment_movie_list

    override fun getViewModel(): MovieListViewModel {
        return ViewModelProvider(this, viewModelFactory)[MovieListViewModel::class.java]
    }


    override fun onFragmentViewReady() {
        val movieListAdapter = MovieListAdapter { model ->
            navigateTo(MovieListFragmentDirections.actionMovieListFragmentToMovieFragment(model))
        }
        viewDataBinding.rvMovies.adapter = movieListAdapter

        lifecycleScope.launchWhenStarted {
            myViewModel.showErrorCause.collect { show ->
                if (show) requireActivity().showToast(myViewModel.errorCause)
            }
        }

    }

}