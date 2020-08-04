package com.br.daniella.frameworkapp.ui.todo_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.data.local.model.ToDo
import kotlinx.android.synthetic.main.list_item_post.view.*
import kotlinx.android.synthetic.main.list_item_todo.view.*

class ToDoListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(todo: ToDo) {
        itemView.text_title_todo.text = todo.title
        todo.completed?.let {
            itemView.checkBox_todo.isChecked = it
        }

    }
}