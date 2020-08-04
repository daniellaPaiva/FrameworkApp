package com.br.daniella.frameworkapp.ui.todo_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo

class ToDoListDiffCallback(
    private val oldList: List<ToDo>,
    private val newList: List<ToDo>
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