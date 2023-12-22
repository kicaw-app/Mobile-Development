package com.satriopndt.kicawcapstone.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.model.KicawModel
import com.satriopndt.kicawcapstone.model.OrderBird
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class HistoryViewModel(private val repository: KicawRepository): ViewModel() {

    private val _uiState = MutableLiveData<List<KicawModel>>()

    val uiState : LiveData<List<KicawModel>> = _uiState

//    private val _groupHistory = MutableStateFlow(repository.getBirdies()
//        .sortedBy { it.name }
//        .groupBy { it.name[0] })

//    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird

   fun getAllHistory() {
       val history = repository.getHistory()
       _uiState.value = history
    }
}