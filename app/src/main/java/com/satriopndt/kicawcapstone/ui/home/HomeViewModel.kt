package com.satriopndt.kicawcapstone.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.model.KicawModel
import com.satriopndt.kicawcapstone.model.OrderBird
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: KicawRepository) : ViewModel() {

    private val _uiState:
        MutableStateFlow<UiState<List<OrderBird>>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<OrderBird>>>
        get() = _uiState

    private val _groupBird = MutableStateFlow(
        repository.getBirdies()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    fun getAllBird() {
        viewModelScope.launch {
            repository.getAll()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { historyBird ->
                    _uiState.value = UiState.Success(historyBird)
                }
        }
    }

    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun Search(newQuery: String){
        _query.value = newQuery
        _groupBird.value = repository.searchBird(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}