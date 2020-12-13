package com.example.domain.repositories

import com.example.domain.models.Movie
import com.example.domain.models.MovieList
import io.reactivex.rxjava3.core.Flowable

interface MovieRepository {
    fun findAll(): Flowable<MovieList>
    fun findOne(id: Int): Flowable<Movie>
}