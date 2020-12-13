package com.example.data.repositories

import com.example.domain.models.Character
import com.example.domain.models.CharacterList
import com.example.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiCharacterRepositoryImp: CharacterRepository {

    @Headers("Content-Type: application/json")
    @GET("people")
    override fun findAll(): Flowable<CharacterList>

    @Headers("Content-Type: application/json")
    @GET("people/{id}")
    override fun findOne(@Path("id") id: Int): Flowable<Character>

}