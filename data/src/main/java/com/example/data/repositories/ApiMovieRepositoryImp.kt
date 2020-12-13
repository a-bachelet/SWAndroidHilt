package com.example.data.repositories

import com.example.domain.models.Movie
import com.example.domain.models.MovieList
import com.example.domain.repositories.MovieRepository
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMovieRepositoryImp: MovieRepository {

    @GET("films")
    override fun findAll(): Flowable<MovieList>

    @GET("films/{id}")
    override fun findOne(@Path("id") id: Int): Flowable<Movie>

}