package com.example.domain.usecases

import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Flowable

class ListCharacters(private val repo: CharacterRepository) {

    operator fun invoke(): Flowable<List<Character>> {
        return repo.findAll().map { d -> d.results }
    }

}