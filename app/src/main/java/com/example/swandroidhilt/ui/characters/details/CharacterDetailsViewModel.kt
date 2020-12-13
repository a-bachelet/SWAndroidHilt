package com.example.swandroidhilt.ui.characters.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import com.example.domain.usecases.DiscoverCharacter
import com.example.domain.usecases.ListCharacters
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsViewModel @ViewModelInject constructor(
    private val repo: CharacterRepository
) : ViewModel() {

    private val _mCharacter: MutableLiveData<Character> = MutableLiveData()

    fun loadCharacter(id: Int) {
        DiscoverCharacter(repo)(id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                _mCharacter.postValue(it)
            }
    }

    fun getCharacter(): MutableLiveData<Character> = _mCharacter

}