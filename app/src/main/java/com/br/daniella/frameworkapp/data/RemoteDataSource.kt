package com.br.daniella.frameworkapp.data

import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo

interface RemoteDataSource {

    fun listAllAlbums(success : (ArrayList<Album>) -> Unit, failure: () -> Unit)

    fun listAllPosts(success : (ArrayList<Post>) -> Unit, failure: () -> Unit)

    fun listAllToDos(success : (ArrayList<ToDo>) -> Unit, failure: () -> Unit)

}