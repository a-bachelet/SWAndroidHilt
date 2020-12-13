package com.example.domain.usecases

import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import io.reactivex.rxjava3.core.Flowable

class ListMovies(private val repo: MovieRepository) {

    operator fun invoke(): Flowable<List<Movie>> {
        return repo.findAll().map {d -> d.results}
    }

}