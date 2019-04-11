package com.example.popularmovies.model.datasource.rxjava

import android.util.Log
import com.example.popularmovies.model.datasource.movie.Movie
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MovieResponseObserver(private var callback: Callback) : Observer<Movie> {

    internal var movie = Movie()

    override fun onSubscribe(d: Disposable) {

        Log.d("TAG", "onSubscribe: SUBSCRIBING")

    }

    override fun onNext(movie: Movie) {

        this.movie = movie
        Log.d("TAG", "onNext: Getting Data")

    }

    override fun onError(e: Throwable) {

        Log.d("TAG", "onError: ", e)

    }

    override fun onComplete() {

        this.callback.onSuccess(movie)

        Log.d("TAG", "Completed!!!")
    }
}
