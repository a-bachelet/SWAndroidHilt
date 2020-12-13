package com.example.domain.usecases

import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Flowable

class DiscoverCharacter(private val repo: CharacterRepository) {

    operator fun invoke(id: Int): Flowable<Character> {
        return repo.findOne(id)
    }

}