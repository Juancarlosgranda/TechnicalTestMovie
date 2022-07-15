package com.jc.app.technical.presentation.ui.features.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jc.app.technical.domain.use_case.GetMovies
import com.jc.app.technical.presentation.ui.base.BaseViewModel
import com.jc.app.technical.presentation.ui.model.Movie
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel @Inject constructor(
    private val getMovies: GetMovies
) : BaseViewModel() {

    private val _movieModelList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieModelList: LiveData<List<Movie>>
        get() = _movieModelList

    init {
        getMovies()
    }

    private fun getMovies() {
        _spinner.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val result = getMovies.invoke()
            withContext(Dispatchers.Main) {
                result.either(::handleUseCaseFailureFromBase) {
                    _movieModelList.value = it.map { movieModel -> Movie.toMovie(movieModel) }
                }
                _spinner.value = false
            }
        }
    }

}