package com.satriopndt.kicawcapstone.ui.forum

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

class ForumViewModel(private val repository: KicawRepository): ViewModel() {

    private val _uiState = MutableLiveData<List<KicawModel>>()

    val uiState : LiveData<List<KicawModel>> = _uiState

//    private val _groupHistory = MutableStateFlow(repository.getBirdies()
//        .sortedBy { it.name }
//        .groupBy { it.name[0] })

//    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird

    private val _groupBird = MutableStateFlow(
        repository.getBirdies()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    fun getAllForum() {
        val forum = repository.getForum()
        _uiState.value = forum
    }

    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun Search(newQuery: String){
        _query.value = newQuery
        _groupBird.value = repository.searchForum(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}