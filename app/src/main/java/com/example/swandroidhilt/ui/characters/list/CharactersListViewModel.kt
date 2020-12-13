package com.example.swandroidhilt.ui.characters.list

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import com.example.domain.usecases.ListCharacters
import io.reactivex.rxjava3.schedulers.Schedulers

class CharactersListViewModel @ViewModelInject constructor(
    private val repo: CharacterRepository
) : ViewModel() {

    private val _mCharacters = MutableLiveData<List<Character>>()

    fun loadCharacters() {
        ListCharacters(repo)()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                _mCharacters.postValue(it)
            }
    }

    fun getCharacters(): MutableLiveData<List<Character>> = _mCharacters

}