package com.example.popularmovies.model.datasource.retrofit

import com.example.popularmovies.model.datasource.Constants.Companion.ACTUAL_BASE_URL
import com.example.popularmovies.model.datasource.Constants.Companion.PATH
import com.example.popularmovies.model.datasource.Constants.Companion.QUERY_RESULTS_1
import com.example.popularmovies.model.datasource.Constants.Companion.QUERY_RESULTS_2
import com.example.popularmovies.model.datasource.movie.Movie
import com.example.popularmovies.model.datasource.okhttp.OkHttpHelper
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitHelper {

    companion object {


        fun createRetrofit(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(ACTUAL_BASE_URL)
                .client(OkHttpHelper.getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

    }
        fun getMovieOb(aKey: String, aSortType: String): Observable<Movie> {

            val retrofit = createRetrofit()
            val remoteService = retrofit.create(RemoteService::class.java)
            return remoteService.getMovieObservable(aKey, aSortType)

        }



    interface RemoteService {

        @GET(PATH)
        fun getMovieObservable(@Query(QUERY_RESULTS_1) key: String,
                               @Query(QUERY_RESULTS_2) sortType: String): Observable<Movie>

    }


}