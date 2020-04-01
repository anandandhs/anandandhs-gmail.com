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
    private var repos = MutableLiveData<List<PostsItem>>()
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

    private fun handleResponse(response:List<PostsItem>){
        repoLoadError.value = false
        repos.value = response.toMutableList()
    }

    private fun handleError(error:Throwable){
        repoLoadError.value = false
    }

    fun getRepos(): LiveData<List<PostsItem>> {
        return repos
    }

    fun getError(): LiveData<Boolean> {
        return repoLoadError
    }

    override fun onCleared() {
        disposable.clear()
    }
}

