package com.sample.MvvmApplication.di

import com.sample.MvvmApplication.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,ActivityBuilderModule::class,ApplicationModule::class])
interface ApplicationComponent :AndroidInjector<SampleApplication>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: SampleApplication):Builder

        fun build():ApplicationComponent
    }
}