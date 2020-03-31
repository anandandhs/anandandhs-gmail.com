package com.sample.MvvmApplication.view.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.MvvmApplication.PostsAdapter
import com.sample.MvvmApplication.R
import com.sample.MvvmApplication.RequestInterface
import com.sample.MvvmApplication.model.PostsItem
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),PostsAdapter.Listener {

    private val TAG = MainActivity::class.java.simpleName
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mAndroidArrayList: ArrayList<PostsItem>? = null
    private var mAdapter: PostsAdapter? = null

    @Inject
    lateinit var requestInterface: RequestInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


        mCompositeDisposable?.add(
            requestInterface.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        )


    }

    private fun handleResponse(androidList: List<PostsItem>) {

        mAndroidArrayList = ArrayList(androidList)
        mAdapter = PostsAdapter(mAndroidArrayList!!, this)

        recyclerView.adapter = mAdapter
    }

    private fun handleError(error: Throwable) {

        Log.d(TAG, error.localizedMessage)

        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(android: PostsItem) {

        Toast.makeText(this, "${android.id} Clicked !", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable?.clear()
    }

}
