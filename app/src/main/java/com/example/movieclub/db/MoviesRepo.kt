package com.example.movieclub.db

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.movieclub.Pojo.MovieModel.MovieModel
import com.example.movieclub.Pojo.MovieModel.Results
import com.example.movieclub.Retrofit.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class MoviesRepo(context: Context) {
   private val  retroClient =RetroClient
   private val database = MoviesDB.getDatabase(context)
   private val moviesDao :MoviesDao= database?.moviesDao()!!

    //insert to database
    fun insert(movie: Results) {
        moviesDao.insert(movie)
    }

    //get updatable database list

    fun getFavList ():MutableLiveData<ArrayList<Results>>{
        val favList=MutableLiveData<ArrayList<Results>>()
        favList.value= moviesDao.favouritesList() as ArrayList<Results>
        return favList
    }
    //check if movie exist
    fun checkIfIdExist(id:Int):Boolean{
        return moviesDao.getmovieByID(id)
    }
    //Api Calls funs
    fun getDiscoverMovies(): MutableLiveData<MovieModel?> {
        val moviesList = MutableLiveData<MovieModel?>()

        retroClient.api.getDiscoverMovies(false, "popularity.desc").enqueue(object : Callback<MovieModel?> {
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                moviesList.value=response.body()
            }
            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
            }
        })
        return moviesList
    }
    fun getTrendMovies():MutableLiveData<MovieModel>{
        val trendMoviesList = MutableLiveData <MovieModel>()
        retroClient.api.getTrending("movie","week",false,"release_date.desc").enqueue(object : Callback<MovieModel?>{
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                trendMoviesList.value= response.body()
            }
            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
            }
        })
           return trendMoviesList
    }
    fun getUpcoming():MutableLiveData<MovieModel>{
        val upcomingList = MutableLiveData <MovieModel>()
        retroClient.api.getUpcoming(false, "popularity.desc").enqueue(object : Callback<MovieModel?>{
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                upcomingList.value= response.body()
            }
            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
            }
        })
        return upcomingList
    }
    fun getTopRated():MutableLiveData<MovieModel>{
        val topRatedList = MutableLiveData <MovieModel>()
        retroClient.api.getTopRated(false, "popularity.desc").enqueue(object : Callback<MovieModel?>{
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                topRatedList.value= response.body()
            }
            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
            }
        })
        return topRatedList
    }




}