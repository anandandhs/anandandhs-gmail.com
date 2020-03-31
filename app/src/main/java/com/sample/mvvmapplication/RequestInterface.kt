package com.sample.mvvmapplication

import com.sample.mvvmapplication.model.PostsItem
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {
    @GET("/posts")
    fun getData() : Observable<List<PostsItem>>
}