package com.example.graphql.repositories.domain

import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repositoriesClient: RepositoriesClient
) {
    suspend fun invoke(): List<RepositoryDto?> {

        return repositoriesClient.getRepositories()
            .sortedBy { it?.stargazerCount }
    }
}