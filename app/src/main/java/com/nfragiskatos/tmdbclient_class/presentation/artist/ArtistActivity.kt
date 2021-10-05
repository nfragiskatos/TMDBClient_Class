package com.nfragiskatos.tmdbclient_class.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfragiskatos.tmdbclient_class.R
import com.nfragiskatos.tmdbclient_class.databinding.ActivityArtistBinding
import com.nfragiskatos.tmdbclient_class.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var adapter: ArtistAdapter

    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val artists = artistViewModel.getArtists()
        artists.observe(this, Observer {
            if (it != null) {
                adapter.setArtists(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No artist data available", Toast.LENGTH_LONG).show()
            }
            binding.artistProgressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtists()
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val updateArtists = artistViewModel.updateArtists()
        updateArtists.observe(this, Observer {
            if (it != null) {
                adapter.setArtists(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No artist data available", Toast.LENGTH_LONG).show()
            }
            binding.artistProgressBar.visibility = View.GONE
        })
    }
}