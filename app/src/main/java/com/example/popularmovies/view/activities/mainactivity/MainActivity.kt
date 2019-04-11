package com.example.popularmovies.view.activities.mainactivity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.databinding.ActivityMainBinding
import com.example.popularmovies.model.datasource.movie.Result
import com.example.popularmovies.view.adapters.RecyclerViewAdapter
import com.example.popularmovies.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    lateinit var  activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        activityMainBinding.mainViewModel
        activityMainBinding.executePendingBindings()

        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        mainViewModel.getMovieLiveData().observe(this,
            Observer<List<Result>> { movies ->
                if (movies != null && movies.isNotEmpty()) {

                    val recyclerViewAdapter = RecyclerViewAdapter(ArrayList(movies))
                    activityMainBinding.recyclerView.adapter = recyclerViewAdapter

                } else {

                    Toast.makeText(baseContext, "Failed to get data. Please check your connection.", Toast.LENGTH_SHORT).show()

                }
            })

    }

}
