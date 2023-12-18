package com.satriopndt.kicawcapstone.ui.forum

import androidx.lifecycle.ViewModel
import com.satriopndt.kicawcapstone.model.ChatModel
import com.satriopndt.kicawcapstone.model.FakeDataChat
import com.satriopndt.kicawcapstone.model.ForumBird
import com.satriopndt.kicawcapstone.repository.KicawRepository
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ForumViewModel(private val repository: KicawRepository) : ViewModel() {
    private val _uiState:
            MutableStateFlow<UiState<List<ForumBird>>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<ForumBird>>>
        get() = _uiState

    private val _groupBird = MutableStateFlow(
        repository.getBirdies()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
}
