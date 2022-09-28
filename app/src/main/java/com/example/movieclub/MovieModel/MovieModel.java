package com.example.movieclub.MovieModel;


import java.util.ArrayList;

public class MovieModel {
    private int page;
    private ArrayList<Results> results;


    public ArrayList<Results> getList() {
        return results;
    }

    public void setList(ArrayList<Results> list) {
        this.results = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
 /*  @GET ("movie/{movie_id}")
    public Call <Results> getMovie (@Path("movie_id") int movie_id);

   */