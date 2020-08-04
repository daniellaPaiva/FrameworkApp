package com.br.daniella.frameworkapp.ui.posts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.daniella.frameworkapp.repository.Repository
import com.br.daniella.frameworkapp.data.local.LocalDataSourceImp
import com.br.daniella.frameworkapp.data.local.model.Post

class PostsViewModel(
    private val repository: Repository
) : ViewModel() {

    private val mRealm = LocalDataSourceImp

    private val _listPosts = MutableLiveData<List<Post>>().apply {
        value = arrayListOf()
    }
    val listPosts: LiveData<List<Post>> = _listPosts

    private val _listPostsFailure = MutableLiveData<String>().apply {
        value = "Failure"
    }
    val listPostsFailure: LiveData<String> = _listPostsFailure

    fun listAllPosts() {
        repository.listAllPosts(
            { result -> handleSuccessListAllPosts(result) },
            { handleFailureListAllPosts() }
        )
    }

    private fun handleSuccessListAllPosts(result: ArrayList<Post>) {
        _listPosts.value = result
    }

    private fun handleFailureListAllPosts() {
        _listPostsFailure.value = "Failure"
    }
}