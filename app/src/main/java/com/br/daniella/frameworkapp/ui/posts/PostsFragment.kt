package com.br.daniella.frameworkapp.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.daniella.frameworkapp.R
import com.br.daniella.frameworkapp.ui.posts.adapter.PostListAdapter
import kotlinx.android.synthetic.main.fragment_posts.*
import org.koin.android.viewmodel.ext.android.viewModel

class PostsFragment : Fragment() {

    private val postsViewModel: PostsViewModel by viewModel()
    private var adapter: PostListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUpView()
        observeAlbumsViewModel()
        postsViewModel.listAllPosts()
    }

    private fun setUpView() {
        adapter = PostListAdapter()
        rv_post_list?.adapter = adapter
        rv_post_list?.layoutManager = LinearLayoutManager(context)

        post_list_progress_bar?.visibility = View.VISIBLE
    }

    private fun observeAlbumsViewModel(){
        postsViewModel.listPosts.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty())
                post_list_progress_bar?.visibility = View.GONE
            adapter?.posts = it
        })
    }
}