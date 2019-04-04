package com.example.popularmovies.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.popularmovies.model.datasource.movie.Movie
import com.example.popularmovies.model.datasource.movie.Result
import com.example.popularmovies.model.datasource.rxjava.Callback
import com.example.popularmovies.model.datasource.rxjava.DataSourceRepo

class MainViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var  movieLiveData: MutableLiveData<List<Result>>

    init {
        init()
    }

    private fun init() {
        movieLiveData = MutableLiveData()
        getResultForAPICall()
    }


    private fun getResultForAPICall() {

        val dataSourceRepo = DataSourceRepo()
        dataSourceRepo.getPopularMovie(object : Callback {
            override fun onSuccess(movie: Movie) {
                Log.d("TAG", "onSuccess: " + movie.totalResults)
                movieLiveData.postValue(movie.results)
            }
        })
    }


    fun getMovieLiveData(): LiveData<List<Result>> {

        return movieLiveData

    }
}
