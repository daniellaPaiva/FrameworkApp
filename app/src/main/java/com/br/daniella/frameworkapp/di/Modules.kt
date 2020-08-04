package com.br.daniella.frameworkapp.di

import com.br.daniella.frameworkapp.data.LocalDataSource
import com.br.daniella.frameworkapp.data.RemoteDataSource
import com.br.daniella.frameworkapp.repository.Repository
import com.br.daniella.frameworkapp.data.local.LocalDataSourceImp
import com.br.daniella.frameworkapp.data.remote.RemoteDataSourceImp
import com.br.daniella.frameworkapp.data.remote.RetrofitClient
import com.br.daniella.frameworkapp.ui.albums.AlbumsViewModel
import com.br.daniella.frameworkapp.ui.posts.PostsViewModel
import com.br.daniella.frameworkapp.ui.todo_list.TodosViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val mainModule = module {
    single {
        Retrofit.Builder().baseUrl(server).addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { (get() as Retrofit).create(RetrofitClient::class.java) }

    single("api") { RemoteDataSourceImp(get()) as RemoteDataSource }
    single("local") { LocalDataSourceImp() as LocalDataSource }
    single("repository") {
        Repository(
            get("api") as RemoteDataSource,
            get("local") as LocalDataSource
        )
    }
    viewModel { AlbumsViewModel(get("repository")) }
    viewModel { PostsViewModel(get("repository")) }
    viewModel { TodosViewModel(get("repository")) }
}


/**
 * Module list
 */
val breedsModule = listOf(mainModule)
const val server = "https://jsonplaceholder.typicode.com/"