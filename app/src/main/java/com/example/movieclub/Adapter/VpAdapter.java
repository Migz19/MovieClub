package com.example.movieclub.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.movieclub.ui.Favourites;
import com.example.movieclub.ui.Home;
import com.example.movieclub.ui.Search;

import java.util.ArrayList;


public class VpAdapter extends FragmentStateAdapter {
    ArrayList <Fragment> fragmentsList = new ArrayList<>();
    public VpAdapter(@NonNull FragmentActivity fragmentActivity,ArrayList<Fragment> fragmentsList) {
        super(fragmentActivity);
        this.fragmentsList=fragmentsList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
         return fragmentsList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentsList.size();
    }
}
