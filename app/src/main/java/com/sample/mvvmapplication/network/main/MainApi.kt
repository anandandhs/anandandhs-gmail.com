package com.sample.mvvmapplication.network.main

import com.sample.mvvmapplication.model.PostsItem
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApi {
    @GET("/posts")
    fun getData() : Observable<List<PostsItem>>
}