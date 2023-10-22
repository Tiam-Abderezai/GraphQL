package com.example.graphql.repositories.domain

interface RepositoriesClient {
    suspend fun getRepositories(): List<RepositoryDto?>
}
