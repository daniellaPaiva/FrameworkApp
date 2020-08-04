package com.br.daniella.frameworkapp.repository

import com.br.daniella.frameworkapp.data.LocalDataSource
import com.br.daniella.frameworkapp.data.RemoteDataSource
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
)  {

    private var listAlbums = arrayListOf<Album>()
    private var listPosts = arrayListOf<Post>()
    private var listToDos = arrayListOf<ToDo>()

    init {
        listAlbums = localDataSource.listAllAlbums()
        listPosts = localDataSource.listAllPosts()
        listToDos = localDataSource.listAllToDos()
    }

    private fun insertAlbums(list: ArrayList<Album>, success: (ArrayList<Album>) -> Unit){
        listAlbums = list
        localDataSource.insertAllAlbums(listAlbums)
        success(listAlbums)
    }

    fun listAllAlbums(success: (ArrayList<Album>) -> Unit, failure: () -> Unit) {
        if (listAlbums.isEmpty())
            remoteDataSource.listAllAlbums({result -> insertAlbums(result) {success(result)} }, {failure()})
        else
            success(listAlbums)
    }

    private fun insertPost(list: ArrayList<Post>, success: (ArrayList<Post>) -> Unit){
        listPosts = list
        localDataSource.insertAllPosts(listPosts)
        success(listPosts)
    }

    fun listAllPosts(success: (ArrayList<Post>) -> Unit, failure: () -> Unit) {
        if (listPosts.isEmpty())
            remoteDataSource.listAllPosts({result -> insertPost(result) {success(result)} }, {failure()})
        else
            success(listPosts)
    }

    private fun insertToDos(list: ArrayList<ToDo>, success: (ArrayList<ToDo>) -> Unit){
        listToDos = list
        localDataSource.insertAllToDos(listToDos)
        success(listToDos)
    }

    fun listAllToDos(success: (ArrayList<ToDo>) -> Unit, failure: () -> Unit) {
        if (listToDos.isEmpty())
            remoteDataSource.listAllToDos({result -> insertToDos(result) {success(result)} }, {failure()})
        else
            success(listToDos)
    }

}