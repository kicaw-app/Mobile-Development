package com.satriopndt.kicawcapstone.ui.forum

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.ui.component.ForumCard
import com.satriopndt.kicawcapstone.ui.component.SearchBarForum
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    navController: NavHostController,
    viewModel: ForumViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(context)
        ),
    ),
) {
    val query by viewModel.query

    val forum by viewModel.uiState.observeAsState(listOf())
    LaunchedEffect(true) {
        viewModel.getAllForum()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(blueBackground)
    ) {
        CenterAlignedTopAppBar(title = {
            Text(
                text = stringResource(id = R.string.forum_screen),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        })
        SearchBarForum(query = query, onQueryChange = viewModel::Search)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            forum.forEach { }
            items(forum.size) {
                // Use a Card to create the chat bubble with title, message, and time
                val listForum = forum[it]
                ForumCard(
                    title = listForum.title,
                    message = listForum.message,
                    time = listForum.time
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    KicawCapstoneTheme {
        ForumScreen(navController = rememberNavController())
    }
}

data class Chat(val title: String, val message: String, val time: String)
