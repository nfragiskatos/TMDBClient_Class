package com.nfragiskatos.tmdbclient_class.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nfragiskatos.tmdbclient_class.R
import com.nfragiskatos.tmdbclient_class.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}