package com.example.popularmovies.model.datasource.okhttp

import okhttp3.OkHttpClient

class OkHttpHelper {

    companion object {

        fun getOkHttp(): OkHttpClient {

            return OkHttpClient.Builder()
                .build()
        }

    }
}