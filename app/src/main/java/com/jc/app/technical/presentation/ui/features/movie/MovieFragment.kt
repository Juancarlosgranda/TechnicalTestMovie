package com.jc.app.technical.presentation.ui.features.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jc.app.technical.BR
import com.jc.app.technical.R
import com.jc.app.technical.presentation.ui.model.Movie

class MovieFragment: Fragment() {

    lateinit var viewDataBinding: ViewDataBinding

    private val args: MovieFragmentArgs by navArgs()

    val movie: Movie by lazy { args.movie }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)
        val rootView = viewDataBinding.root
        viewDataBinding.setVariable(BR.movieModel, movie)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.executePendingBindings()
    }
}