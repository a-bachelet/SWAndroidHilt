package com.example.swandroidhilt.ui.movies.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import com.example.domain.usecases.DiscoverMovie
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailsViewModel @ViewModelInject constructor(
    private val repo: MovieRepository
) : ViewModel() {

    private val _mMovie: MutableLiveData<Movie> = MutableLiveData()

    fun loadMovie(id: Int) {
        DiscoverMovie(repo)(id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                _mMovie.postValue(it)
            }
    }

    fun getMovie(): MutableLiveData<Movie> = _mMovie

}