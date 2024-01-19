package com.example.youtube.ui.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.model.PlaylistItemModel
import com.example.youtube.databinding.ItemDescBinding

class PlaylistItemsAdapter : ListAdapter<PlaylistItemModel.Item, PlaylistItemsViewHolder>(
    PlaylistItemsDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistItemsViewHolder {
        return PlaylistItemsViewHolder(
            ItemDescBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistItemsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PlaylistItemsViewHolder(private val binding: ItemDescBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PlaylistItemModel.Item?) = with(binding) {
        tvTitle.text = item?.snippet?.title
        Glide.with(image).load(item?.snippet?.thumbnails?.default?.url).into(image)
    }
}

class PlaylistItemsDiffCallback : DiffUtil.ItemCallback<PlaylistItemModel.Item>() {
    override fun areItemsTheSame(
        oldItem: PlaylistItemModel.Item,
        newItem: PlaylistItemModel.Item
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PlaylistItemModel.Item,
        newItem: PlaylistItemModel.Item
    ) = oldItem == newItem
}