package com.example.swandroidhilt.ui.movies.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Movie
import com.example.swandroidhilt.R


class MoviesListAdapter: RecyclerView.Adapter<MoviesListHolder>() {
    var dataSet: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListHolder {
        val v: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movies_list_item, parent, false)

        return MoviesListHolder(v)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MoviesListHolder, position: Int) {
        val tv: TextView = holder.itemView
            .findViewById<TextView>(R.id.movies_list_item_textView)

        tv.text = dataSet[position].title

        tv.setOnClickListener {
            val bundle: Bundle = bundleOf("movie_id" to position + 1)
            holder.itemView.findNavController().navigate(R.id.action_navigation_movies_list_to_navigation_movie_details, bundle)
        }
    }

}

class MoviesListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)