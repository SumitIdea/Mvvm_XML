package com.example.mvvm_xml.retrofit

import com.example.mvvm_xml.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("popular?")
    fun getPopularMovies(
        @Query("api_key")
        api_key:String
    ):Call<Movies>

}