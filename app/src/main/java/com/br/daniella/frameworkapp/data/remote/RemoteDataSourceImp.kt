package com.br.daniella.frameworkapp.data.remote

import com.br.daniella.frameworkapp.data.RemoteDataSource
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo
import com.br.daniella.frameworkapp.data.remote.model.AlbumResponse
import com.br.daniella.frameworkapp.data.remote.model.PostResponse
import com.br.daniella.frameworkapp.data.remote.model.ToDoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImp(private val api: RetrofitClient) :
    RemoteDataSource {

    override fun listAllAlbums(success: (ArrayList<Album>) -> Unit, failure: () -> Unit) {
        val call: Call<List<AlbumResponse>> = api.listAllAlbums()
        call.enqueue(object : Callback<List<AlbumResponse>> {
            override fun onResponse(
                call: Call<List<AlbumResponse>>,
                response: Response<List<AlbumResponse>>
            ) {
                if (response.isSuccessful) {
                    val posts = arrayListOf<Album>()
                    response.body()?.forEach {
                        val post =
                            Album()
                        post.userId = it.userId
                        post.id = it.id
                        post.title = it.title
                        posts.add(post)
                    }
                    success(posts)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<AlbumResponse>>, t: Throwable) {
                failure()
            }
        })
    }

    override fun listAllPosts(success: (ArrayList<Post>) -> Unit, failure: () -> Unit) {
        val call: Call<List<PostResponse>> = api.listAllPosts()
        call.enqueue(object : Callback<List<PostResponse>> {
            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>
            ) {
                if (response.isSuccessful) {
                    val albums = arrayListOf<Post>()
                    response.body()?.forEach {
                        val post =
                            Post()
                        post.userId = it.userId
                        post.id = it.id
                        post.title = it.title
                        post.body = it.body
                        albums.add(post)
                    }
                    success(albums)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                failure()
            }
        })
    }

    override fun listAllToDos(success: (ArrayList<ToDo>) -> Unit, failure: () -> Unit) {
        val call: Call<List<ToDoResponse>> = api.listAllToDos()
        call.enqueue(object : Callback<List<ToDoResponse>> {
            override fun onResponse(
                call: Call<List<ToDoResponse>>,
                response: Response<List<ToDoResponse>>
            ) {
                if (response.isSuccessful) {
                    val toDos = arrayListOf<ToDo>()
                    response.body()?.forEach {
                        val post =
                            ToDo()
                        post.userId = it.userId
                        post.id = it.id
                        post.title = it.title
                        post.completed = it.completed
                        toDos.add(post)
                    }
                    success(toDos)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<ToDoResponse>>, t: Throwable) {
                failure()
            }
        })
    }
}