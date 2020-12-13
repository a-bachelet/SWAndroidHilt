package com.example.domain.usecases

import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import io.reactivex.rxjava3.core.Flowable

class DiscoverMovie(private val repo: MovieRepository) {

    operator fun invoke(id: Int): Flowable<Movie> {
        return repo.findOne(id)
    }

}