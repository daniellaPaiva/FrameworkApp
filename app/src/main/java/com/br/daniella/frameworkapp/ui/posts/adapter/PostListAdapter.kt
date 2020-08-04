package com.br.daniella.frameworkapp.ui.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.ui.todo_list.adapter.ToDoListDiffCallback
import com.br.daniella.frameworkapp.ui.todo_list.adapter.ToDoListItemViewHolder

class PostListAdapter : RecyclerView.Adapter<PostListItemViewHolder>() {

    var posts = emptyList<Post>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                PostListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_post, parent, false)

        return PostListItemViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: PostListItemViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size
}