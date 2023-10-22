package com.example.graphql.repositories.data

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.graphql.RepositoriesQuery
import com.example.graphql.repositories.domain.RepositoriesClient
import com.example.graphql.repositories.domain.RepositoryDto

class ApolloRepositoriesClient(
    private val apolloRepositoriesClient: ApolloClient,
) : RepositoriesClient {
    override suspend fun getRepositories(): List<RepositoryDto?> {
        return apolloRepositoriesClient
            .query(RepositoriesQuery())
            .execute()
            .data
            ?.search
            ?.edges?.map {
                it?.node?.onRepository?.toRepository()
            } ?: emptyList()
    }
}
