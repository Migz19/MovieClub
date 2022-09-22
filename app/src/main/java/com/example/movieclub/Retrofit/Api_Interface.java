package com.example.movieclub.Retrofit;

import com.example.movieclub.Pojo.MovieModel.MovieModel;
import com.example.movieclub.Pojo.MovieModel.Results;
import com.example.movieclub.Pojo.SeriesModel.LatestSeries;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api_Interface {
    @GET("discover/movie?api_key=844fc399f9e19fa60f68672ca29a948f")
    public Call <MovieModel> getDiscoverMovies(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
    @GET("trending/{media_type}/{time_window}?api_key=844fc399f9e19fa60f68672ca29a948f")
    public Call <MovieModel>getTrending(
            @Path("media_type")String media_type,
            @Path("time_window")String time_window,
            @Query("include_adult")boolean adult,
            @Query("sort_by") String sort
    );
    @GET ("movie/{movie_id}?api_key=844fc399f9e19fa60f68672ca29a948f")
    public Call <Results> getMovie(@Path("movie_id")int movie_id);
    @GET("movie/upcoming?api_key=844fc399f9e19fa60f68672ca29a948f")
    public Call <MovieModel> getUpcoming(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
    @GET("movie/top_rated?api_key=844fc399f9e19fa60f68672ca29a948f")
    public Call <MovieModel> getTopRated(
            @Query("include_adult")boolean adult,
            @Query ("sort_by")String sort
    );
}
