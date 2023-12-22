package com.satriopndt.kicawcapstone.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.repository.KicawRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: KicawRepository): ViewModel() {

    fun getSession() = repository.getSession().asLiveData()

    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }
    }
}