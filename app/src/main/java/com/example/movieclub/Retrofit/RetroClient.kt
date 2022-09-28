package com.example.movieclub.Retrofit

import com.example.movieclub.retrofit.Api_Interface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {
    val api: Api_Interface by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_Interface::class.java)
    }
}
