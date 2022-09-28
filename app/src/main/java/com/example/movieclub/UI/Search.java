package com.example.movieclub.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieclub.R;
import com.example.movieclub.databinding.FragmentFavouritesBinding;
import com.example.movieclub.databinding.FragmentSearchBinding;

public class Search extends Fragment {


    public Search() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSearchBinding binding ;
        binding = FragmentSearchBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }
}