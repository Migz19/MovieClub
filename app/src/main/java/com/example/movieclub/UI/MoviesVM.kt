package com.example.movieclub.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.movieclub.MovieModel.Results
import com.example.movieclub.db.MoviesDB
import com.example.movieclub.db.MoviesRepo

class MoviesVM(application: Application) : AndroidViewModel(application) {
val database = MoviesDB.getDatabase(application)
private val moviesRepo = MoviesRepo(application)
     val moviesList =  moviesRepo.getDiscoverMovies()
     val trendingList = moviesRepo.getTrendMovies()
     val favouriteList = moviesRepo.getFavList()
    val topRatedList = moviesRepo.getTopRated()
    val upcomingList = moviesRepo.getUpcoming()

fun checkIfMovieExisted(id: Int):Boolean{
    return moviesRepo.checkIfIdExist(id)
}
     fun addtoFav(movie:Results){
        moviesRepo.insert(movie)
         //TODO 3ayz a8yyr di
         favouriteList.value?.add(movie)
    }

   /* fun getMovieById(id:Int):MutableLiveData<Results>{
        val movie = MutableLiveData<Results>()
        RetroClient.api.getMovie(id).enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
                movie.value=response.body()
            }
            override fun onFailure(call: Call<Results?>, t: Throwable) {
                Toast.makeText(getApplication(),t.message,Toast.LENGTH_SHORT).show()
            }
        })
        return movie
    }

    */

}