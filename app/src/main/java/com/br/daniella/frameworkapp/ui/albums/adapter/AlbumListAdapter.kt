package com.br.daniella.frameworkapp.ui.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.ui.todo_list.adapter.ToDoListItemViewHolder

class AlbumListAdapter : RecyclerView.Adapter<AlbumListItemViewHolder>() {

    var albums = emptyList<Album>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                AlbumListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_album, parent, false)

        return AlbumListItemViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: AlbumListItemViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int = albums.size
}