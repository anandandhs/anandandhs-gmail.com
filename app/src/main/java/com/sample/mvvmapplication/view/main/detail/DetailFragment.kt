package com.sample.mvvmapplication.view.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.mvvmapplication.R
import com.sample.mvvmapplication.view.main.MainActivity
import dagger.android.support.DaggerFragment
import java.util.zip.Inflater

class DetailFragment : DaggerFragment(){
    private val TAG = DetailFragment::class.java.simpleName

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }
}