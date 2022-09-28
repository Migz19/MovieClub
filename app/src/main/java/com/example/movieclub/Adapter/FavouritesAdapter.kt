package com.example.movieclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieclub.MovieModel.Results
import com.example.movieclub.R
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.ListAdapter
import com.example.movieclub.databinding.FavRecyclerviewBinding

class FavouritesAdapter : ListAdapter<Results,FavouritesAdapter.FavViewHolder>(DiffUtilCallback()) {

    class FavViewHolder private constructor(val binding: FavRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        private val title : TextView = itemView.findViewById(R.id.titleFavTV)
        private val release_date :TextView =itemView.findViewById(R.id.dateFavTV)
        private val overview : TextView = itemView.findViewById(R.id.overviewFavTV)
        private val poster : ImageView = itemView.findViewById(R.id.favIV)
        fun bind (item:Results){ //instead of binding each time in onBinding
            binding.titleFavTV.text=item.title
           binding.dateFavTV.text=item.release_date
            binding.overviewFavTV.text=item.overview
            Picasso.get()
                .load("https://image.tmdb.org/t/p/original/" + item.poster)
                .into(binding.favIV)
        }
        companion object {       //Instead of inflating in onCreate
            fun from(parent: ViewGroup): FavViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavRecyclerviewBinding.inflate(layoutInflater,parent,false)
                return FavViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        return FavViewHolder.from(parent)
    }



    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val item: Results = getItem(position)
        holder.bind(item)
    }


}
class DiffUtilCallback: DiffUtil.ItemCallback<Results>(){
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id==newItem.id
    }

}