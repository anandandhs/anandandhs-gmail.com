package com.sample.mvvmapplication.view.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.mvvmapplication.R
import com.sample.mvvmapplication.model.PostsItem
import com.sample.mvvmapplication.view.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),
    PostsAdapter.Listener {

    private val TAG = MainActivity::class.java.simpleName

    private var mAndroidArrayList: List<PostsItem> = ArrayList()
    private var mAdapter: PostsAdapter? = null
    private lateinit var viewModel:MainViewModel

    @Inject
    lateinit var providerFactory:ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this,providerFactory).get(MainViewModel::class.java)
        viewModel.fetchRepo()
        initRecyclerView()

    }

    private fun initRecyclerView() {

        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        viewModel.getError().observe(this, Observer {isError->
            if(isError==false){
                viewModel.getRepos().observe(this, Observer { response->
                    mAndroidArrayList = response.toMutableList()
                })
            }
        })

        mAdapter = PostsAdapter(mAndroidArrayList,this)
        recyclerView.adapter = mAdapter
        Log.d(TAG,mAndroidArrayList.size.toString())
    }

    override fun onItemClick(android: PostsItem) {
        Toast.makeText(this, "${android.id} Clicked !", Toast.LENGTH_SHORT).show()
    }
}
