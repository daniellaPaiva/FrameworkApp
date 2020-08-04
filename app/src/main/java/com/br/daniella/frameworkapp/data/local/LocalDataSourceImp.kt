package com.br.daniella.frameworkapp.data.local

import com.br.daniella.frameworkapp.data.LocalDataSource
import com.br.daniella.frameworkapp.data.local.model.Album
import com.br.daniella.frameworkapp.data.local.model.Post
import com.br.daniella.frameworkapp.data.local.model.ToDo
import io.realm.Realm

class LocalDataSourceImp : LocalDataSource {

    companion object {
        private val mRealm: Realm
            get() = RealmManager.mRealm

    }

    override fun insertAllAlbums(list: ArrayList<Album>) {
        mRealm.use {
            mRealm.executeTransaction { realm1 ->
                list.forEach {
                    realm1.insertOrUpdate(it)
                }
            }

            mRealm.close()
        }
    }

    override fun listAllAlbums() : ArrayList<Album> {
        mRealm.use { realm ->
            var postList: MutableList<Album>? = null
            mRealm.executeTransaction {
                postList =
                    it.where(Album::class.java)
                        .findAll()
            }

            mRealm.close()
            return convertMutableListToArrayList(postList)
        }
    }

    override fun insertAllPosts(list: ArrayList<Post>) {
        mRealm.use {
            mRealm.executeTransaction { realm1 ->
                list.forEach {
                    realm1.insertOrUpdate(it)
                }
            }

            mRealm.close()
        }
    }

    override fun listAllPosts() : ArrayList<Post> {
        mRealm.use { realm ->
            var postList: MutableList<Post>? = null
            mRealm.executeTransaction {
                postList =
                    it.where(Post::class.java)
                        .findAll()
            }

            mRealm.close()
            return convertMutableListToArrayList(postList)
        }
    }

    override fun insertAllToDos(list: ArrayList<ToDo>) {
        mRealm.use {
            mRealm.executeTransaction { realm1 ->
                list.forEach {
                    realm1.insertOrUpdate(it)
                }
            }

            mRealm.close()
        }
    }

    override fun listAllToDos() : ArrayList<ToDo> {
        mRealm.use { realm ->
            var postList: MutableList<ToDo>? = null
            mRealm.executeTransaction {
                postList =
                    it.where(ToDo::class.java)
                        .findAll()
            }

            mRealm.close()
            return convertMutableListToArrayList(postList)
        }
    }

    private fun <T> convertMutableListToArrayList(
        historicList: MutableList<T>?
    ): ArrayList<T> {
        val list = arrayListOf<T>()
        historicList?.forEach {
            list.add(it)
        }

        return list
    }

}

