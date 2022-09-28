package com.example.movieclub.retrofit;

import com.example.movieclub.BuildConfig;
import com.example.movieclub.MovieModel.MovieModel;
import com.example.movieclub.MovieModel.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api_Interface {
    String API_KEY = BuildConfig.API_KEY;
    @GET("discover/movie?api_key="+API_KEY)
    public Call <MovieModel> getDiscoverMovies(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
    @GET("trending/{media_type}/{time_window}?api_key="+API_KEY)
     Call <MovieModel>getTrending(
            @Path("media_type")String media_type,
            @Path("time_window")String time_window,
            @Query("include_adult")boolean adult,
            @Query("sort_by") String sort
    );
    @GET ("movie/{movie_id}?api_key="+API_KEY)
     Call <Results> getMovie(@Path("movie_id")int movie_id);

    @GET("movie/upcoming?api_key="+API_KEY)
     Call <MovieModel> getUpcoming(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
    @GET("movie/top_rated?api_key="+API_KEY)
     Call <MovieModel> getTopRated(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
}
