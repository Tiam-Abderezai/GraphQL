package com.example.graphql.repositories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graphql.R
import com.example.graphql.repositories.domain.RepositoryDto
import com.example.graphql.repositories.presentation.RepositoriesViewState

@Composable
fun RepositoriesScreen(state: RepositoriesViewState) {
    val repositories = state.repositories
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .background(color = Color.DarkGray),
    ) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.outlineVariant),
            ) {
                Spacer(modifier = Modifier.width(64.dp))
                Text(text = "#", fontSize = 32.sp, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "GitHub Repository", fontSize = 32.sp, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
            }
        }
        repositories?.forEach { repo ->
            RepositoryScreen(repo)
        }
    }
}

@Composable
private fun RepositoryScreen(repo: RepositoryDto?) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(48.dp).padding(end = 16.dp),
                painter = painterResource(id = R.drawable.icon_star),
                contentDescription = stringResource(R.string.repository_star),
            )
            Text(text = "${repo?.stargazerCount}", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(32.dp))
            Text(text = "${repo?.name}", fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
fun RepositoriesScreenPreview() {
    RepositoriesScreen(state = RepositoriesViewState())
}
