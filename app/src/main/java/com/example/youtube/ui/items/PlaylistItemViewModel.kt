package com.example.youtube.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.data.model.PlaylistItemModel
import com.example.youtube.data.repository.YouTubeRepository
import com.example.youtube.data.service.Resource

class PlaylistItemsViewModel(private val repository: YouTubeRepository) : ViewModel() {
    fun getPlaylistItems(
        getId: String,
        count: Int
    ): LiveData<Resource<List<PlaylistItemModel.Item>>> = repository.getPlaylistItems(getId, count)
}