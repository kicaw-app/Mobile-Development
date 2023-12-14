package com.satriopndt.kicawcapstone.ui.history

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

//    private val _uiState: MutableStateFlow<UiState<List<OrderBird>>> = MutableStateFlow(UiState.Loading)
//
//    val uiState: StateFlow<UiState<List<OrderBird>>> get() = _uiState
//
//    private val _groupHistory = MutableStateFlow(repository.getBirdies()
//        .sortedBy { it.name }
//        .groupBy { it.name[0] })
//
//    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird
//
//   fun getAllBird() {
//        viewModelScope.launch {
//            repository.getAll()
//                .catch {
//                    _uiState.value = UiState.Error(it.message.toString())
//                }
//                .collect { historyBird ->
//                    _uiState.value = UiState.Success(historyBird)
//                }
//        }
//    }
}