package com.example.data.repositories

import com.example.domain.models.Character
import com.example.domain.models.CharacterList
import com.example.domain.repositories.CharacterRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor() : CharacterRepository {
    override fun findAll(): Flowable<CharacterList> {
        return Flowable.just(CharacterList(List(10) { i -> Character("Character $i") }))
    }

    override fun findOne(id: Int): Flowable<Character> {
        return Flowable.just(Character("Character $id"))
    }
}