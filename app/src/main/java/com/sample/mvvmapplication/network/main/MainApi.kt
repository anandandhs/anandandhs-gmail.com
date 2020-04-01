package com.sample.mvvmapplication.network.main

import com.sample.mvvmapplication.model.PostsItem
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {
    @GET("/posts")
    fun getData() : Single<ArrayList<PostsItem>>
}