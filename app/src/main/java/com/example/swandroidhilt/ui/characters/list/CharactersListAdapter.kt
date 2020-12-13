package com.example.swandroidhilt.ui.characters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Character
import com.example.swandroidhilt.R


class CharactersListAdapter: RecyclerView.Adapter<CharactersListHolder>() {
    var dataSet: List<Character> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersListHolder {
        val v: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.characters_list_item, parent, false)

        return CharactersListHolder(v)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CharactersListHolder, position: Int) {
        val tv: TextView = holder.itemView
            .findViewById(R.id.characters_list_item_textView)

        tv.text = dataSet[position].name

        tv.setOnClickListener {
            val bundle: Bundle = bundleOf("character_id" to position + 1)
            holder.itemView.findNavController().navigate(R.id.action_navigation_characters_list_to_navigation_character_details, bundle)
        }
    }

}

class CharactersListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)