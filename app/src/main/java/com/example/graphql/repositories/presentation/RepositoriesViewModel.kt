package com.example.graphql.repositories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphql.repositories.domain.GetRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(RepositoriesViewState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update {
                it.copy(
                    repositories = getRepositoriesUseCase?.invoke(),
                    isLoading = true,
                )
            }
        }
    }

    fun getRepositories(code: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    repositories = getRepositoriesUseCase?.invoke(),
                )
            }
        }
    }
}
