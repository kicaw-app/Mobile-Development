package com.satriopndt.kicawcapstone.ui.forum

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.model.ForumModel
import com.satriopndt.kicawcapstone.model.KicawModel
import com.satriopndt.kicawcapstone.model.OrderBird
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class ForumViewModel(private val repository: KicawRepository): ViewModel() {

    private val _uiState = MutableLiveData<List<ForumModel>>()
    val uiState : LiveData<List<ForumModel>> = _uiState

//    private val _groupHistory = MutableStateFlow(repository.getBirdies()
//        .sortedBy { it.name }
//        .groupBy { it.name[0] })

//    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupBird

    private val _groupChat = MutableStateFlow(
        repository.getForum()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )

    fun getAllForum() {
        val forum = repository.getForum()
        _uiState.value = forum
    }


    private val _groupDiscuss = MutableStateFlow(
        repository.getForum()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )

    val groupForum: StateFlow<Map<Char, List<ForumModel>>> get() = _groupDiscuss
    val groupBirds: StateFlow<Map<Char, List<ForumModel>>> get() = _groupChat

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun Search(newQuery: String){
        _query.value = newQuery
//        _groupDiscuss.value = repository.searchForum(_query.value)
        _groupChat.value = repository.searchForum(_query.value)
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    }
}