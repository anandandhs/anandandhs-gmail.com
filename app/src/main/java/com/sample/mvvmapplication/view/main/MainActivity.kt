package com.sample.mvvmapplication.view.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.mvvmapplication.PostsAdapter
import com.sample.mvvmapplication.R
import com.sample.mvvmapplication.network.main.MainApi
import com.sample.mvvmapplication.model.PostsItem
import com.sample.mvvmapplication.view.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),PostsAdapter.Listener {

    private val TAG = MainActivity::class.java.simpleName
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mAndroidArrayList: ArrayList<PostsItem> = ArrayList()
    private var mAdapter: PostsAdapter? = null
    private lateinit var viewModel:MainViewModel

    @Inject
    lateinit var providerFactory:ViewModelProviderFactory

//    @Inject
//    lateinit var requestInterface: MainApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this,providerFactory).get(MainViewModel::class.java)

        mCompositeDisposable = CompositeDisposable()

        initRecyclerView()

        loadJSON()

    }

    private fun initRecyclerView() {

        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun loadJSON() {


//        mAndroidArrayList = viewModel.getJason().value
//        mAdapter = PostsAdapter(mAndroidArrayList, this)
//        recyclerView.adapter = mAdapter
//        mCompositeDisposable?.add(
//
//        )


    }

//    private fun handleResponse(androidList: List<PostsItem>) {
//
//        mAndroidArrayList = ArrayList(androidList)
//        mAdapter = PostsAdapter(mAndroidArrayList!!, this)
//
//        recyclerView.adapter = mAdapter
//    }
//
//    private fun handleError(error: Throwable) {
//
//        Log.d(TAG, error.localizedMessage)
//
//        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
//    }

    override fun onItemClick(android: PostsItem) {

        Toast.makeText(this, "${android.id} Clicked !", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        mCompositeDisposable?.clear()
    }

}
