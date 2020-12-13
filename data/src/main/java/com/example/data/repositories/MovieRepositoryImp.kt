package com.example.data.repositories

import com.example.domain.models.Movie
import com.example.domain.models.MovieList
import com.example.domain.repositories.MovieRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor() : MovieRepository {
    override fun findAll(): Flowable<MovieList> {
        return Flowable.just(MovieList(List(10) { i -> Movie("Movie $i") }))
    }

    override fun findOne(id: Int): Flowable<Movie> {
        return Flowable.just(Movie("Movie $id"))
    }
}