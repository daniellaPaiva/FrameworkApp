package com.br.daniella.frameworkapp.data

import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo

interface LocalDataSource {

    fun listAllAlbums() : ArrayList<Album>

    fun insertAllAlbums(list: ArrayList<Album>)

    fun listAllPosts() : ArrayList<Post>

    fun insertAllPosts(list: ArrayList<Post>)

    fun listAllToDos() : ArrayList<ToDo>

    fun insertAllToDos(list: ArrayList<ToDo>)

}