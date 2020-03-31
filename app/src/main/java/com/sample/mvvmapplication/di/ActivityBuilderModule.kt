package com.sample.mvvmapplication.di

import com.sample.mvvmapplication.view.main.MainActivity
import com.sample.mvvmapplication.view.main.MainModule
import com.sample.mvvmapplication.view.main.MainViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class,MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}