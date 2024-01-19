package com.example.youtube.ui.items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.youtube.data.service.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.youtube.databinding.ActivityPlaylistItemsBinding

class PlaylistItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistItemsBinding
    private val viewModel: PlaylistItemsViewModel by viewModel()
    private val playlistItemsAdapter by lazy {
        PlaylistItemsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPlaylistItems.adapter = playlistItemsAdapter

        val getId = intent.getStringExtra("id").toString()
        val getTitle = intent.getStringExtra("title").toString()
        val getDesc = intent.getStringExtra("description").toString()
        val count: Int = intent.getIntExtra("count", 0)

        binding.tvTitle.text = getTitle
        binding.tvDescription.text = getDesc
        viewModel.getPlaylistItems(getId, count).observe(this) { result ->
            when (result) {
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    playlistItemsAdapter.submitList(result.data)
                }
            }
        }
    }
}