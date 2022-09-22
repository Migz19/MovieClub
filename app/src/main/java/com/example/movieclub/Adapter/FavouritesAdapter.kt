package com.example.movieclub.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieclub.Pojo.MovieModel.Results
import com.example.movieclub.R
import com.squareup.picasso.Picasso

class FavouritesAdapter(var favList: ArrayList<Results>) :
    RecyclerView.Adapter<FavouritesAdapter.favViewHolder>() {
    /* = arrayListOf()
    get() = field
    set(value) {field=value}*/

    class favViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.titleFavTV)
        val release_date :TextView =itemView.findViewById(R.id.dateFavTV)
        val overview : TextView = itemView.findViewById(R.id.overviewFavTV)
        val poster : ImageView = itemView.findViewById(R.id.favIV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fav_recyclerview, parent, false)
        return favViewHolder(view)
    }

    override fun onBindViewHolder(holder: favViewHolder, position: Int) {
        val results: Results = favList[position]
        Picasso.get()
            .load("https://image.tmdb.org/t/p/original/" + results.poster)
            .into(holder.poster)
        holder.title.text = results.title
        holder.overview.text=results.overview
        holder.release_date.text = results.release_date
    }

    override fun getItemCount(): Int {
        return favList.size
    }
    fun setData(favList: ArrayList<Results>): ArrayList<Results> {
        return favList
    }
}