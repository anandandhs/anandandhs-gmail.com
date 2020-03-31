package com.sample.mvvmapplication.di

import com.sample.mvvmapplication.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,ActivityBuilderModule::class,ApplicationModule::class,ViewModelFactoryModule::class])
interface ApplicationComponent :AndroidInjector<SampleApplication>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: SampleApplication):Builder

        fun build():ApplicationComponent
    }
}