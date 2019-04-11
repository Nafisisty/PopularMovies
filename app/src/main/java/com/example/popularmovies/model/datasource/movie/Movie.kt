package com.example.popularmovies.model.datasource.movie

import android.os.Parcel
import android.os.Parcelable.Creator
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Movie : Parcelable {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    protected constructor(`in`: Parcel) {
        this.page = `in`.readValue(Int::class.java.classLoader) as Int
        this.totalResults = `in`.readValue(Int::class.java.classLoader) as Int
        this.totalPages = `in`.readValue(Int::class.java.classLoader) as Int
        `in`.readList(
            this.results,
            com.example.popularmovies.model.datasource.movie.Result::class.java!!.getClassLoader()
        )
    }

    constructor()

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(page)
        dest.writeValue(totalResults)
        dest.writeValue(totalPages)
        dest.writeList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Movie> = object : Creator<Movie> {


            override fun createFromParcel(`in`: Parcel): Movie {
                return Movie(`in`)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }

        }
    }

}
