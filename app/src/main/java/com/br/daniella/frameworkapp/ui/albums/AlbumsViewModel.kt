package com.br.daniella.frameworkapp.ui.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.repository.Repository

class AlbumsViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _listAlbums = MutableLiveData<List<Album>>().apply {
        value = arrayListOf()
    }
    val listAlbums: LiveData<List<Album>> = _listAlbums

    private val _listAlbumsFailure = MutableLiveData<String>().apply {
        value = "Failure"
    }
    val listAlbumsFailure: LiveData<String> = _listAlbumsFailure

    fun listAllAlbums() {
        repository.listAllAlbums(
            { result -> handleSuccessListAllAlbums(result) },
            { handleFailureListAllAlbums() }
        )
    }

    private fun handleSuccessListAllAlbums(result: ArrayList<Album>) {
        _listAlbums.value = result
    }

    private fun handleFailureListAllAlbums() {
        _listAlbumsFailure.value = "Failure"
    }
}