package com.sample.mvvmapplication.view.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.mvvmapplication.PostsAdapter
import com.sample.mvvmapplication.model.PostsItem
import com.sample.mvvmapplication.network.main.MainApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainViewModel @Inject constructor(val mainApi: MainApi):ViewModel(){

//    private val postsItemLiveData = MutableLiveData<ArrayList<PostsItem>>()
//    private val postsItemErrorLiveData = MutableLiveData<Throwable>()
//    private var requestStatus:Boolean = false
//    private val TAG = MainViewModel::class.java.simpleName
//    fun getJason():MutableLiveData<ArrayList<PostsItem>>{
//        mainApi.getData()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(this::handleResponse, this::handleError)
//
////        if(requestStatus)
//            return postsItemLiveData
////        else
////            return  postsItemErrorLiveData
//    }
//
//    private fun handleResponse(androidList: ArrayList<PostsItem>) {
//        postsItemLiveData.value = androidList
//        requestStatus = true
//    }
//
//    private fun handleError(error: Throwable) {
//        postsItemErrorLiveData.value = error
//
//    }

}