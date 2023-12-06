package com.satriopndt.kicawcapstone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.home.HomeViewModel

class ViewModelFactory(private val repository: KicawRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}