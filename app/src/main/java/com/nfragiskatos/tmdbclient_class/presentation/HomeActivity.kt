package com.nfragiskatos.tmdbclient_class.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nfragiskatos.tmdbclient_class.R
import com.nfragiskatos.tmdbclient_class.databinding.ActivityHomeBinding
import com.nfragiskatos.tmdbclient_class.presentation.artist.ArtistActivity
import com.nfragiskatos.tmdbclient_class.presentation.movie.MovieActivity
import com.nfragiskatos.tmdbclient_class.presentation.tvshows.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener{
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }

        // Access api key
//        BuildConfig.THEMOVIEDB_API_KEY

    }
}