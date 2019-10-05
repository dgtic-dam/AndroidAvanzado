package com.cybertech.asynctaskexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybertech.asynctaskexample.R
import com.cybertech.asynctaskexample.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieAdapter(val context: Context, val movies:ArrayList<Movie>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.posterImageView.setImageResource(R.mipmap.ic_launcher)
        holder.titleTextView.text=movies[position].title
        holder.yearTextView.text=movies[position].year
        holder.timeTextView.text=movies[position].runtime
    }
}

class MovieViewHolder(view: View):RecyclerView.ViewHolder(view){
    val posterImageView=view.posterImageView
    val yearTextView=view.yearTextView
    val timeTextView=view.timeTextView
    val titleTextView=view.titleTextView
}