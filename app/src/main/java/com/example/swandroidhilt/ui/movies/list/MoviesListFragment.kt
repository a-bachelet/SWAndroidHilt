package com.example.swandroidhilt.ui.movies.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swandroidhilt.R
import com.example.swandroidhilt.ui.characters.list.CharactersListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment: Fragment() {

    private val vm: MoviesListViewModel by viewModels()

    lateinit var recycler: RecyclerView
    lateinit var adapter: MoviesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movies_list, container, false)

        recycler = root.findViewById(R.id.movies_list_recycler)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context)

        adapter = MoviesListAdapter()

        recycler.adapter = adapter

        vm.getMovies().observe(viewLifecycleOwner) {
            adapter.dataSet = it
            adapter.notifyDataSetChanged()
        }

        vm.loadMovies()

        return root
    }

}