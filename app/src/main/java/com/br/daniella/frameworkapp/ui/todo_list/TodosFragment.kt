package com.br.daniella.frameworkapp.ui.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.data.local.model.ToDo
import com.br.daniella.frameworkapp.ui.todo_list.adapter.ToDoListAdapter
import kotlinx.android.synthetic.main.fragment_todos.*
import org.koin.android.viewmodel.ext.android.viewModel

class TodosFragment : Fragment() {

    private val todosViewModel: TodosViewModel by viewModel()
    private var adapter: ToDoListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todos, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUpView()
        setUpClickListeners()
        observeAlbumsViewModel()
        getListAllToDos()
    }

    private fun setUpView() {
        adapter = ToDoListAdapter()
        rv_todo_list?.adapter = adapter
        rv_todo_list?.layoutManager = LinearLayoutManager(context)
    }

    private fun setUpClickListeners() {
        text_failure_todo?.setOnClickListener {
            getListAllToDos()
        }
    }

    private fun getListAllToDos() {
        text_failure_todo?.visibility = View.GONE
        todo_list_progress_bar?.visibility = View.VISIBLE
        todosViewModel.listAllToDos()
    }

    private fun observeAlbumsViewModel() {
        todosViewModel.listToDos.observe(viewLifecycleOwner, Observer {
            setUpViewOnSuccess(it)
        })

//        todosViewModel.listTodoListFailure.observe(viewLifecycleOwner, Observer {
//            setUpViewOnFailure()
//        })
    }

    private fun setUpViewOnSuccess(list: List<ToDo>) {
        if (list.isNotEmpty())
            todo_list_progress_bar?.visibility = View.GONE
        adapter?.todos = list
    }

    private fun setUpViewOnFailure() {
        rv_todo_list?.visibility = View.GONE
        todo_list_progress_bar?.visibility = View.GONE
        text_failure_todo?.visibility = View.VISIBLE
    }
}