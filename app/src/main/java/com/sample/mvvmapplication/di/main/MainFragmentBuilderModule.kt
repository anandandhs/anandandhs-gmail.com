package com.sample.mvvmapplication.di.main

import com.sample.mvvmapplication.view.main.detail.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideDetailFragment():DetailFragment
}