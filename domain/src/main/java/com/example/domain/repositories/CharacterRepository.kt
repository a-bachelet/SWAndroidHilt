package com.example.domain.repositories

import com.example.domain.models.Character
import com.example.domain.models.CharacterList
import io.reactivex.rxjava3.core.Flowable

interface CharacterRepository {
    fun findAll(): Flowable<CharacterList>
    fun findOne(id: Int): Flowable<Character>
}