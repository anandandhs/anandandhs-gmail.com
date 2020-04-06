package com.sample.mvvmapplication.di

import com.sample.mvvmapplication.di.main.DetailFragmentViewModelModule
import com.sample.mvvmapplication.di.main.MainFragmentBuilderModule
import com.sample.mvvmapplication.view.main.MainActivity
import com.sample.mvvmapplication.di.main.MainModule
import com.sample.mvvmapplication.di.main.MainViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class,MainFragmentBuilderModule::class,DetailFragmentViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity
}