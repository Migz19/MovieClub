package com.example.movieclub.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import com.example.movieclub.Adapter.VpAdapter;
import com.example.movieclub.databinding.ActivityMainBinding;
import com.example.movieclub.db.MoviesDB;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        MoviesDB database = MoviesDB.getDatabase(getBaseContext());

        startFragment(this);
    }

    public void startFragment (FragmentActivity fragmentActivity){
        //Create Fragments List , send it to the adapter and wait for the return
        ArrayList <Fragment> fragmentsList = new ArrayList<>();
        fragmentsList.add(new Home());
        fragmentsList.add(new Favourites());
        //fragmentsList.add(new Search());
        VpAdapter vpAdapter= new VpAdapter(this,fragmentsList);
        binding.mainViewpager.setAdapter(vpAdapter);
        new TabLayoutMediator(binding.tabLayout, binding.mainViewpager, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    switch (position){
                        case 0 : tab.setText("Home");
                        break;
                        case 1 :tab.setText("Favourites");
                        break;
                    }
                }
            }).attach();
    }

}