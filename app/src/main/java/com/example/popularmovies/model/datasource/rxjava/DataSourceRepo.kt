package com.example.popularmovies.model.datasource.rxjava

import com.example.popularmovies.model.datasource.retrofit.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DataSourceRepo {

    internal var retrofitHelper = RetrofitHelper()

    fun getPopularMovie(callback: Callback) {

        retrofitHelper.getMovieOb("1173e8e0543a9fc4b37cac32d448b130", "popularity.desc")
            .subscribeOn(Schedulers.io())
            .retryWhen { o -> o.take(5).delay(2, TimeUnit.SECONDS) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(ISSResponseObserver(callback))

    }


}