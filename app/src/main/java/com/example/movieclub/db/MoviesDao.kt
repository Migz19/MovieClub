package com.example.movieclub.db

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieclub.MovieModel.Results

@Dao
interface MoviesDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: Results?)
    @NonNull
    @Query("Select * from results order by release_date")
    fun favouritesList(): List<Results?>
    @Query ("Select Exists (select 1 from results where id = :movie_id)")
    fun getmovieByID(movie_id:Int):Boolean
    @Query ("delete from results")
    fun delete();

}