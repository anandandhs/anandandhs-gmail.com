package com.sample.mvvmapplication.view.main

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor():ViewModel(){
    private val TAG = "MainViewModel"
    init {
        Log.d(TAG,"main viewmodel running...")
    }
}