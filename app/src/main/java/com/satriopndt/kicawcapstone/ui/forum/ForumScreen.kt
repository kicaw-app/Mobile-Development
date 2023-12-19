package com.satriopndt.kicawcapstone.ui.forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.component.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ForumViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        ),
    )
) {
    val query = viewModel.query

    // Define some sample data for the chat bubbles
    val chats = listOf(
        Chat(title = "burung kenari", message = "mike: kira - kira ini dijual dmn ya", time = "10 menit"),
        Chat(title = "burung nuri", message = "jhon: keren nii", time = "05 menit")
    )
    CenterAlignedTopAppBar(title = {
        androidx.compose.material.Text(
            text = stringResource(id = R.string.forum_screen),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        androidx.compose.material.Icon(imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = stringResource(
                id = R.string.btn_back
            ),
            modifier = Modifier
                .padding(16.dp)
                .clickable { navController.navigate(Screen.Home.route) })
    })
    // Use a Scaffold to arrange the app bar, content, and bottom bar
    Scaffold(

//        floatingActionButton = {
//            // Use a FloatingActionButton to create the "+" button for creating new chat
//            FloatingActionButton(onClick = { /* TODO: Handle new chat button */ }) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "New Chat")
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        // Use a Box to arrange the content and the search bar
        Box(modifier = Modifier.padding(paddingValues)) {
            // Use a LazyColumn to create the list of chat bubbles that can be scrolled
//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(chats) { chat ->
//                    // Use a Card to create the chat bubble with title, message, and time
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        elevation = CardDefaults
//                            .cardElevation(defaultElevation = 4.dp)
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .padding(8.dp)
//                                .fillMaxWidth(),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            // Use an Image to display the chat icon from a local resource
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_chat), // TODO: Change this to your own icon resource
//                                contentDescription = "Chat Icon",
//                                modifier = Modifier
//                                    .size(48.dp)
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Column {
//                                // Use a Text to display the chat title with bold style
//                                Text(text = chat.title, style = typography.body1.copy(fontWeight = FontWeight.Bold))
//                                // Use a Text to display the chat message with ellipsis
//                                Text(text = chat.message, style = typography.body2, maxLines = 1, overflow = TextOverflow.Ellipsis)
//                            }
//                            Spacer(modifier = Modifier.weight(1f))
//                            // Use a Text to display the chat time with gray color
//                            Text(text = chat.time, style = typography.caption.copy(color = Color.Gray))
//                        }
//                    }
//                }
//            }
            // Use a TextField to create the search bar with label and placeholder
            SearchBar(
                query = query,
                onQueryChange = viewModel::Search
            )
        }
    }
}

// Define a data class to hold the chat information
data class Chat(val title: String, val message: String, val time: String)
