package com.example.youtube.di

import com.example.youtube.ui.items.PlaylistItemsViewModel
import com.example.youtube.ui.playlists.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel {
        PlaylistViewModel(get())
    }
    viewModel {
        PlaylistItemsViewModel(get())
    }
}