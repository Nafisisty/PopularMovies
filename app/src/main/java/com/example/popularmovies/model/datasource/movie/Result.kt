package com.example.popularmovies.model.datasource.movie

import android.os.Parcel
import android.os.Parcelable.Creator
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Result : Parcelable {

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("video")
    @Expose
    var video: Boolean? = null
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Float? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("popularity")
    @Expose
    var popularity: Float? = null
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null
    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null
    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null
    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null
    @SerializedName("overview")
    @Expose
    var overview: String? = null
    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    protected constructor(`in`: Parcel) {
        this.voteCount = `in`.readValue(Int::class.java.classLoader) as Int
        this.id = `in`.readValue(Int::class.java.classLoader) as Int
        this.video = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.voteAverage = `in`.readValue(Float::class.java.classLoader) as Float
        this.title = `in`.readValue(String::class.java.classLoader) as String
        this.popularity = `in`.readValue(Float::class.java.classLoader) as Float
        this.posterPath = `in`.readValue(String::class.java.classLoader) as String
        this.originalLanguage = `in`.readValue(String::class.java.classLoader) as String
        this.originalTitle = `in`.readValue(String::class.java.classLoader) as String
        `in`.readList(this.genreIds, Int::class.java.classLoader)
        this.backdropPath = `in`.readValue(String::class.java.classLoader) as String
        this.adult = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.overview = `in`.readValue(String::class.java.classLoader) as String
        this.releaseDate = `in`.readValue(String::class.java.classLoader) as String
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(voteCount)
        dest.writeValue(id)
        dest.writeValue(video)
        dest.writeValue(voteAverage)
        dest.writeValue(title)
        dest.writeValue(popularity)
        dest.writeValue(posterPath)
        dest.writeValue(originalLanguage)
        dest.writeValue(originalTitle)
        dest.writeList(genreIds)
        dest.writeValue(backdropPath)
        dest.writeValue(adult)
        dest.writeValue(overview)
        dest.writeValue(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Result> = object : Creator<Result> {


            override fun createFromParcel(`in`: Parcel): Result {
                return Result(`in`)
            }

            override fun newArray(size: Int): Array<Result?> {
                return arrayOfNulls(size)
            }

        }
    }

}
