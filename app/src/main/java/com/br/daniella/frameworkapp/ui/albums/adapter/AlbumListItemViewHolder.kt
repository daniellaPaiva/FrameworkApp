package com.br.daniella.frameworkapp.ui.albums.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.data.local.model.Album
import kotlinx.android.synthetic.main.list_item_album.view.*
import kotlinx.android.synthetic.main.list_item_post.view.*

class AlbumListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(album: Album) {
        itemView.text_title_album?.text = album.title
    }
}