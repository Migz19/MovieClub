package com.example.movieclub.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movieclub.MovieModel.Results;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Results.class}, version =3, exportSchema = false)
public abstract class MoviesDB extends RoomDatabase {
    public abstract MoviesDao moviesDao();
    private static volatile MoviesDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized MoviesDB  getDatabase(final Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MoviesDB.class, "FavouritesDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }


        return INSTANCE;
    }
}
