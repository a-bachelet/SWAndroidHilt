package com.example.swandroidhilt.ui.movies.details

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
class MovieDetailsFragment: Fragment() {

    private val vm: MovieDetailsViewModel by viewModels()

    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie_details, container, false)

        textView = root.findViewById(R.id.movie_details_textview)

        vm.getMovie().observe(viewLifecycleOwner) {
            textView.text = it.title
        }

        vm.loadMovie(arguments?.get("movie_id") as Int)

        return root
    }

}