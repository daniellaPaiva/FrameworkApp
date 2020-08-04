package com.br.daniella.frameworkapp.ui.todo_list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.daniella.frameworkapp.repository.Repository
import com.br.daniella.frameworkapp.data.local.model.ToDo

class TodosViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _listToDos = MutableLiveData<List<ToDo>>().apply {
        value = arrayListOf()
    }
    val listToDos: LiveData<List<ToDo>> = _listToDos

    private val _listToDosFailure = MutableLiveData<String>().apply {
        value = "Failure"
    }
    val listTodoListFailure: LiveData<String> = _listToDosFailure

    fun listAllToDos() {
        repository.listAllToDos(
            { result -> handleSuccessListAllToDos(result) },
            { handleFailureListAllToDos() }
        )
    }

    private fun handleSuccessListAllToDos(result: ArrayList<ToDo>) {
        _listToDos.value = result
    }

    private fun handleFailureListAllToDos() {
        _listToDosFailure.value = "Failure"
    }
}