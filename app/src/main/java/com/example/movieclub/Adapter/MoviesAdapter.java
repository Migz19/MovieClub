package com.example.movieclub.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieclub.Pojo.MovieModel.Results;
import com.example.movieclub.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.Movies_VH>{
    private ArrayList <Results> moviesList;
    private Onclick onitemClick ;
    public MoviesAdapter(ArrayList<Results> moviesList,Onclick onitemclick) {
        this.moviesList = moviesList;
        this.onitemClick = onitemclick;
    }



    public class Movies_VH extends RecyclerView.ViewHolder{
        TextView titleTv;
        ImageView movieIcon;
        CardView cardView;
        ImageButton like;
        public Movies_VH(@NonNull View itemView) {
            super(itemView);
            movieIcon =itemView.findViewById(R.id.movieIcon);
            titleTv = itemView.findViewById(R.id.titleTv);
            cardView = itemView.findViewById(R.id.cardview);
            like = itemView.findViewById(R.id.like_btn);
        }
    }
    @NonNull
    @Override
    public Movies_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new MoviesAdapter.Movies_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Movies_VH holder, int position) {
        Results results = moviesList.get(position);
        Picasso.get()
                .load("https://image.tmdb.org/t/p/original/"+results.getPoster())
                .into(holder.movieIcon);
       // Glide.with(context).load(results.getPoster()).into(holder.movieIcon);
        holder.titleTv.setText(results.getTitle());
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onitemClick.onItemClick(results);
            }
        });

    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
