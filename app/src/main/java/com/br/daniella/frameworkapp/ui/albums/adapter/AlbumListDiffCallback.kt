package com.br.daniella.frameworkapp.ui.albums.adapter

import androidx.recyclerview.widget.DiffUtil
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post

class AlbumListDiffCallback(
    private val oldList: List<Album>,
    private val newList: List<Album>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].userId?.equals(newList[newItemPosition].userId)!!
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}