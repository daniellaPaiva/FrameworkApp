package com.br.daniella.frameworkapp.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.ui.albums.adapter.AlbumListAdapter
import kotlinx.android.synthetic.main.fragment_albums.*
import org.koin.android.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment() {

    private val albumsViewModel: AlbumsViewModel by viewModel()
    private var adapter: AlbumListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUpView()
        observeAlbumsViewModel()
        albumsViewModel.listAllAlbums()
    }

    private fun setUpView() {
        adapter = AlbumListAdapter()
        rv_album_list?.adapter = adapter
        rv_album_list?.layoutManager = LinearLayoutManager(context)

        album_list_progress_bar?.visibility = View.VISIBLE
    }

    private fun observeAlbumsViewModel(){
        albumsViewModel.listAlbums.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty())
                album_list_progress_bar?.visibility = View.GONE
            adapter?.albums = it
        })

        albumsViewModel.listAlbumsFailure.observe(viewLifecycleOwner, Observer {

        })
    }
}