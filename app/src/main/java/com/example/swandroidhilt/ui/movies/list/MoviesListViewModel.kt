package com.example.swandroidhilt.ui.movies.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import com.example.domain.usecases.ListMovies
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviesListViewModel @ViewModelInject constructor(
    private val repo: MovieRepository
) : ViewModel() {

    private val _mMovies: MutableLiveData<List<Movie>> = MutableLiveData()

    fun loadMovies() {
        ListMovies(repo)()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                _mMovies.postValue(it)
            }
    }

    fun getMovies(): MutableLiveData<List<Movie>> = _mMovies

}