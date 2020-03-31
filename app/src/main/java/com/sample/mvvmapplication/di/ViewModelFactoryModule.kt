package com.sample.mvvmapplication.di

import androidx.lifecycle.ViewModelProvider
import com.sample.mvvmapplication.view.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory

}