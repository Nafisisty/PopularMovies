package com.example.popularmovies.view.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.databinding.ItemBinding
import com.example.popularmovies.model.datasource.Constants.Companion.IMAGE_BASE_URL
import com.example.popularmovies.model.datasource.movie.Result
import kotlinx.android.synthetic.main.item.view.*
import java.util.ArrayList



class RecyclerViewAdapter(private var resultArrayList: ArrayList<Result>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var viewGroupTemp: ViewGroup

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerViewAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.item, viewGroup, false
        )

        viewGroupTemp = viewGroup
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapter.ViewHolder, position: Int) {

        val movie = resultArrayList[position]
        Log.d("TAG", "Movie" + movie.originalTitle)
        if (movie != null) {
            viewHolder.itemBinding.movie = movie

            Glide.with(viewGroupTemp.context)
                .load(IMAGE_BASE_URL + movie.posterPath)
                .into(viewHolder.itemView.posterImageView)
        }
    }

    override fun getItemCount(): Int {
        return resultArrayList.size
    }

    inner class ViewHolder(internal var itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.getRoot())
}