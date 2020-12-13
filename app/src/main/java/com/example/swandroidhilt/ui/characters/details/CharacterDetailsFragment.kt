package com.example.swandroidhilt.ui.characters.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.swandroidhilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment: Fragment() {

    private val vm: CharacterDetailsViewModel by viewModels()

    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_character_details, container, false)

        textView = root.findViewById(R.id.character_details_textview)

        vm.getCharacter().observe(viewLifecycleOwner) {
            textView.text = it.name
        }

        vm.loadCharacter(arguments?.get("character_id") as Int)

        return root
    }

}