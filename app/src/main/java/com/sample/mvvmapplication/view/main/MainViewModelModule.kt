package com.sample.mvvmapplication.view.main

import androidx.lifecycle.ViewModel
import com.sample.mvvmapplication.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindAuthViewModel(viewModel: MainViewModel): ViewModel
}