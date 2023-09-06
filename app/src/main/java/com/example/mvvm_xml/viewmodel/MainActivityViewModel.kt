package com.example.mvvm_xml.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_xml.data.Movies
import com.example.mvvm_xml.data.Result
import com.example.mvvm_xml.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var TAG = "MainActivityViewModel"
    private var movieLiveData = MutableLiveData<List<Result>>()

    init {
        movieLiveData = MutableLiveData()
    }

    fun observeMovieLiveData() : MutableLiveData<List<Result>>{
        return movieLiveData
    }


    fun getPopularMoviesApi() {
        RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
//                    movieLiveData.value = response.body()!!.results
                     movieLiveData.postValue(response.body()!!.results)
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("$TAG",t.message.toString())
            }
        })
    }

}