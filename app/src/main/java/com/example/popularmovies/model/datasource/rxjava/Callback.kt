package com.example.popularmovies.model.datasource.rxjava

import com.example.popularmovies.model.datasource.movie.Movie

interface Callback {
    fun onSuccess(movie: Movie)
}