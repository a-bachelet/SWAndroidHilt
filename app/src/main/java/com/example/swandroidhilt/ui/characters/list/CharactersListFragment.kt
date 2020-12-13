package com.example.swandroidhilt.ui.characters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swandroidhilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListFragment: Fragment() {

    private val vm: CharactersListViewModel by viewModels()

    lateinit var recycler: RecyclerView
    lateinit var adapter: CharactersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_characters_list, container, false)

        recycler = root.findViewById(R.id.characters_list_recycler)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context)

        adapter = CharactersListAdapter()

        recycler.adapter = adapter

        vm.getCharacters().observe(viewLifecycleOwner) {
            adapter.dataSet = it
            adapter.notifyDataSetChanged()
        }

        vm.loadCharacters()

        return root
    }

}