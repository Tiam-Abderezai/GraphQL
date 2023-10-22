package com.example.graphql.repositories.presentation

import com.example.graphql.repositories.domain.RepositoryDto

data class RepositoriesViewState(
    val repositories: List<RepositoryDto?>? = emptyList<RepositoryDto>(),
    val isLoading: Boolean = false
)