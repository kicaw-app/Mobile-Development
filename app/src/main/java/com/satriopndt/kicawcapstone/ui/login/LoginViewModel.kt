package com.satriopndt.kicawcapstone.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.data.UserModel
import com.satriopndt.kicawcapstone.data.response.LoginResponse
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: KicawRepository): ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    private val _upload = MutableLiveData<UiState<LoginResponse>>()
    val upload: LiveData<UiState<LoginResponse>> = _upload

    fun login(email: String, password: String){
        viewModelScope.launch {
            repository.login(email, password).asFlow().collect{
                _upload.value = it
            }
        }
    }

    fun saveSession(userModel: UserModel){
        viewModelScope.launch {
            repository.saveSession(userModel)
        }
    }
}