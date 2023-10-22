package com.example.graphql.repositories

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.graphql.repositories.domain.RepositoryDto
import com.example.graphql.repositories.presentation.RepositoriesViewState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoriesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun repositoriesScreen_displaysItems() {
        val repositories = listOf(
            RepositoryDto(name = "Repo1", stargazerCount = 100),
            RepositoryDto(name = "Repo2", stargazerCount = 200),
            // Add more items for testing if necessary
        )
        val state = RepositoriesViewState(repositories = repositories)

        composeTestRule.setContent {
            RepositoriesScreen(state = state)
        }

        // Check if items are displayed
        repositories.forEach { repo ->
            composeTestRule.onNodeWithText(repo.name).assertExists()
            composeTestRule.onNodeWithText("${repo.stargazerCount}").assertExists()
        }
    }
}
