package com.example.movieclub.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.movieclub.adapter.MoviesAdapter;
import com.example.movieclub.adapter.Onclick;
import com.example.movieclub.MovieModel.Results;
import com.example.movieclub.databinding.FragmentHomeBinding;
import com.example.movieclub.db.MoviesDB;

import java.util.ArrayList;

public class Home extends Fragment implements  Onclick {
    MoviesAdapter adapter;
    FragmentHomeBinding binding;
    ArrayList<Results> moviesList;
    MoviesVM  moviesVM;
    MoviesDB database ;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       database = MoviesDB.getDatabase(requireActivity());
        moviesVM = new ViewModelProvider(requireActivity()).get(MoviesVM.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(),container,false);
        getTrending();
        getDiscover();
        getUpcoming();
        getTopRated();
        return binding.getRoot();
    }

    //function to get All Movies
    public void getDiscover() {
        moviesVM.getMoviesList().observe(getViewLifecycleOwner(), movieModel -> {
            moviesList = new ArrayList<>(moviesVM.getMoviesList().getValue().getList());
            bindRecycler(moviesList, binding.discoverRV);
        });
    }
    //Function to get Trending Movies
    public void getTrending() {
        moviesVM.getTrendingList().observe(getViewLifecycleOwner(), movieModel -> {
            moviesList = new ArrayList<>(moviesVM.getTrendingList().getValue().getList());
            bindRecycler(moviesList, binding.trendingRV);
        });
    }
    //function to get NowPlaying Movies
    public void getUpcoming() {
        moviesVM.getUpcomingList().observe(getViewLifecycleOwner(), movieModel -> {
            moviesList = new ArrayList<>(moviesVM.getUpcomingList().getValue().getList());
            bindRecycler(moviesList, binding.nwplayingRV);
        });
    }
    //Function to get Top Rated Movies
    public void getTopRated() {
            moviesVM.getTopRatedList().observe(getViewLifecycleOwner(), movieModel -> {
                moviesList = new ArrayList<>(moviesVM.getTopRatedList().getValue().getList());
                bindRecycler(moviesList, binding.topRtdRV);
            });
}
    //Function to bind recyclerview with data
    public void bindRecycler (ArrayList<Results> list,RecyclerView rv){
        adapter = new MoviesAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Results movie) {
        if (moviesVM.checkIfMovieExisted(movie.getId()))
            Toast.makeText(requireActivity(), "Already Added", Toast.LENGTH_SHORT).show();
      else {
            moviesVM.addtoFav(movie);
            Toast.makeText(requireActivity(), movie.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }
    //On Item click in recyclerview



}