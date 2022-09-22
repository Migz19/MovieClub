package com.example.movieclub.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieclub.Adapter.FavouritesAdapter;
import com.example.movieclub.Pojo.MovieModel.Results;
import com.example.movieclub.databinding.FragmentFavouritesBinding;

import java.util.ArrayList;

public class Favourites extends Fragment {
FavouritesAdapter adapter;
FragmentFavouritesBinding binding ;
MoviesVM movieVM ;
    public Favourites() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieVM = new ViewModelProvider(requireActivity()).get(MoviesVM.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavouritesBinding.inflate(getLayoutInflater(),container,false);
        ArrayList<Results> favList = movieVM.getFavouriteList().getValue();
        adapter= new FavouritesAdapter(favList);
        /*movieVM.getFavouriteList().observe(getViewLifecycleOwner(), results -> {
            adapter.setFavList(results);
        });*/

        bindRecycler();
        return binding.getRoot();
    }
    private void bindRecycler(){
        RecyclerView rv = binding.favRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(false);
        rv.setAdapter(adapter);
    }

}