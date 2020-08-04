package com.br.daniella.frameworkapp.data.remote

import com.br.daniella.frameworkapp.data.remote.model.AlbumResponse
import com.br.daniella.frameworkapp.data.remote.model.PostResponse
import com.br.daniella.frameworkapp.data.remote.model.ToDoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitClient {

    @GET("/albums")
    fun listAllAlbums(): Call<List<AlbumResponse>>

    @GET("/posts")
    fun listAllPosts(): Call<List<PostResponse>>

    @GET("/todos")
    fun listAllToDos(): Call<List<ToDoResponse>>
}