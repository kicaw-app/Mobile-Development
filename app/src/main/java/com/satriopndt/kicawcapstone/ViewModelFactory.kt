package com.satriopndt.kicawcapstone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.forum.ForumViewModel
import com.satriopndt.kicawcapstone.ui.history.HistoryViewModel
import com.satriopndt.kicawcapstone.ui.home.HomeViewModel

class ViewModelFactory(private val repository: KicawRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return HistoryViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(ForumViewModel::class.java)){
            return ForumViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}