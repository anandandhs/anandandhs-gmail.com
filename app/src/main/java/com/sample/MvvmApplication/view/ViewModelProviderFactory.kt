package com.sample.MvvmApplication.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelProviderFactory @Inject constructor(val creators: Map<Class<out ViewModel>, Provider<ViewModel>>?): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel?>? = creators!![modelClass]
        if (creator == null) {

            // if the viewmodel has not been created
            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators.entries) { // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass);
        }

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

}