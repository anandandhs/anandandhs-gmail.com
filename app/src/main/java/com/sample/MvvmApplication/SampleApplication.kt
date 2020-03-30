package com.sample.MvvmApplication

import com.sample.MvvmApplication.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SampleApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerApplicationComponent.builder().application(this).build()
    }

}