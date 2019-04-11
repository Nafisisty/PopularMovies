package com.example.popularmovies.model.datasource

class Constants {
    companion object {

//        val FULL_EXAMPLE_URL = "https://api.themoviedb.org/3/discover/movie?api_key=1173e8e0543a9fc4b37cac32d448b130&&sort_by=popularity.desc"
        const val ACTUAL_BASE_URL = "https://api.themoviedb.org/"
        const val PATH = "3/discover/movie/"
        const val QUERY_RESULTS_1 = "api_key"
        const val QUERY_RESULTS_2 = "sort_by"

        const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w342/"

        const val API_KEY = "1173e8e0543a9fc4b37cac32d448b130"
        const val SORT_TYPE = "popularity.desc"
    }
}