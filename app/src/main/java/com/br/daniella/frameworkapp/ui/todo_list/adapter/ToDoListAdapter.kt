package com.br.daniella.frameworkapp.ui.todo_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.data.local.model.ToDo

class ToDoListAdapter : RecyclerView.Adapter<ToDoListItemViewHolder>() {

    var todos = emptyList<ToDo>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ToDoListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_todo, parent, false)

        return ToDoListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoListItemViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size
}