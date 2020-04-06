package com.sample.mvvmapplication.di.main

import androidx.lifecycle.ViewModel
import com.sample.mvvmapplication.di.ViewModelKey
import com.sample.mvvmapplication.view.main.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailFragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}