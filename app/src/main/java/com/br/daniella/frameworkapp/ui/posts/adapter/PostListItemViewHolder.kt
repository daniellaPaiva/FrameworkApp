package com.br.daniella.frameworkapp.ui.posts.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.data.local.model.Post
import kotlinx.android.synthetic.main.list_item_post.view.*

class PostListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: Post) {
        itemView.text_title_post.text = user.title
        itemView.text_body_post.text = user.body
    }
}