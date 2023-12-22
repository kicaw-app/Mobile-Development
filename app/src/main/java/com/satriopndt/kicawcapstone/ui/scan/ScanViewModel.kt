package com.satriopndt.kicawcapstone.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.satriopndt.kicawcapstone.data.response.ScanResponse
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState

class ScanViewModel(private val repository: KicawRepository): ViewModel() {

    private val _uploadPredict = MutableLiveData<UiState<ScanResponse>>()
    val uploadPredict : LiveData<UiState<ScanResponse>> = _uploadPredict

}