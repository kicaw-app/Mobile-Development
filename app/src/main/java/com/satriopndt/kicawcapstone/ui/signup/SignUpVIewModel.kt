package com.satriopndt.kicawcapstone.ui.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.data.response.RegisterResponse
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.launch

class SignUpVIewModel(private val repository: KicawRepository): ViewModel() {

    var name by mutableStateOf("")
    var username by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    private val _upload = MutableLiveData<UiState<RegisterResponse>>()
    val upload: LiveData<UiState<RegisterResponse>> = _upload

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun uploadData(name: String, username: String, email: String, password: String){
        viewModelScope.launch {
            try {
                _isLoading.postValue(true)

                repository.register(name, username, email, password).asFlow().collect{
                    _upload.value = it
                }
            } finally {
                _isLoading.postValue(false)
            }

        }
    }
}