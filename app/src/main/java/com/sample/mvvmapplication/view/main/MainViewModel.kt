package com.sample.mvvmapplication.view.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.mvvmapplication.model.PostsItem
import com.sample.mvvmapplication.network.main.MainApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject



class MainViewModel @Inject constructor(private val mainApi: MainApi):ViewModel(){

    private val disposable = CompositeDisposable()
    private var repos = MutableLiveData<ArrayList<PostsItem>>()
    private var repoLoadError = MutableLiveData<Boolean>()
    private val TAG = MainViewModel::class.java.simpleName
    fun fetchRepo(){
        Log.d(TAG,"View Model Running")
        disposable.add(
            mainApi.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse,this::handleError)
        )
    }

    private fun handleResponse(response:ArrayList<PostsItem>){
        repoLoadError.value = false
        repos.value = response
        Log.d(TAG,response.size.toString())

    }

    private fun handleError(error:Throwable){
        repoLoadError.value = false
        Log.d(TAG,error.message)
    }

    fun getRepos(): LiveData<ArrayList<PostsItem>> {
        return repos
    }

    fun getError(): LiveData<Boolean> {
        return repoLoadError
    }

    override fun onCleared() {
        disposable.clear()
    }
}

