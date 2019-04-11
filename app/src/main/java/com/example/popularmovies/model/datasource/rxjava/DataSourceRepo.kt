package com.example.popularmovies.model.datasource.rxjava

import com.example.popularmovies.model.datasource.Constants.Companion.API_KEY
import com.example.popularmovies.model.datasource.Constants.Companion.SORT_TYPE
import com.example.popularmovies.model.datasource.retrofit.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DataSourceRepo {

    private var retrofitHelper = RetrofitHelper()

    fun getPopularMovie(callback: Callback) {

        retrofitHelper.getMovieOb(API_KEY, SORT_TYPE)
            .subscribeOn(Schedulers.io())
            .retryWhen { o -> o.take(5).delay(2, TimeUnit.SECONDS) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(MovieResponseObserver(callback))

    }


}