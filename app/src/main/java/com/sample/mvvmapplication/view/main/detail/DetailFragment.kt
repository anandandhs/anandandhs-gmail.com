package com.sample.mvvmapplication.view.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sample.mvvmapplication.R
import com.sample.mvvmapplication.view.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment(){
    private val TAG = DetailFragment::class.java.simpleName

    private lateinit var viewModel:DetailViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this,providerFactory).get(DetailViewModel::class.java)
    }
}