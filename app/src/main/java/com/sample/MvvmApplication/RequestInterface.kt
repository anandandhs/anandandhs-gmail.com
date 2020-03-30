package com.sample.MvvmApplication

import com.sample.MvvmApplication.model.PostsItem
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {
    @GET("/posts")
    fun getData() : Observable<List<PostsItem>>
}