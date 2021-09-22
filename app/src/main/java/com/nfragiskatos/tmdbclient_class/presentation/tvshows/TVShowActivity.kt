package com.nfragiskatos.tmdbclient_class.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nfragiskatos.tmdbclient_class.R
import com.nfragiskatos.tmdbclient_class.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvshow)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
    }
}