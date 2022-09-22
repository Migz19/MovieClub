package com.example.movieclub.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.movieclub.UI.Favourites;
import com.example.movieclub.UI.Home;
import com.example.movieclub.UI.Search;

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
