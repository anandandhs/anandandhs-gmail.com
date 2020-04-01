package com.sample.mvvmapplication.view.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.sample.mvvmapplication.PostsAdapter
import com.sample.mvvmapplication.model.PostsItem
import com.sample.mvvmapplication.network.main.MainApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainViewModel @Inject constructor(val mainApi: MainApi):ViewModel(){

    private val postsItemLiveData = MediatorLiveData<List<PostsItem>>()
    private val TAG = MainViewModel::class.java.simpleName

    fun callPostApi(){
        Log.d(TAG,"View Model Running")
        val source = LiveDataReactiveStreams.fromPublisher<List<PostsItem>> {
            mainApi.getData()
                .subscribeOn(Schedulers.io())
        }

        postsItemLiveData.addSource(source, Observer {data->
            postsItemLiveData.value = data
            postsItemLiveData.removeSource(source)
        })
    }

    fun observePosts():LiveData<List<PostsItem>> = postsItemLiveData



}