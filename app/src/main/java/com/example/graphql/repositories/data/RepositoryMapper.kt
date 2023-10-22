package com.example.graphql.repositories.data

import com.example.graphql.RepositoriesQuery
import com.example.graphql.repositories.domain.RepositoryDto

fun RepositoriesQuery.OnRepository.toRepository(): RepositoryDto {
    return RepositoryDto(
        name = name ?: "",
        stargazerCount = stargazerCount ?: 0,
    )
}