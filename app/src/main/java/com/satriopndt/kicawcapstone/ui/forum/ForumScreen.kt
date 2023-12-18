package com.satriopndt.kicawcapstone.ui.forum

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    // State untuk menyimpan data chat
    val chatList = mutableStateListOf(
        Chat("burung kenari", "Mike", "kira-kira ini dijual dmn ya", 03),
        Chat("burung nuri", "John", "kerenn nii", 55)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tombol menu
            IconButton(
                onClick = { /* Handle menu */ },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Menu",
                    modifier = Modifier.size(24.dp)
                )
            }

            // Tombol chat
            IconButton(
                onClick = { /* Handle chat */ },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Chat",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

    // Judul
    Text(
        text = "List Chat",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        style = MaterialTheme.typography.h2
    )

    // Tombol pencarian
    Button(
        onClick = { /* Handle search */ },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .align(Alignment.CenterHorizontally)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Search",
            modifier = Modifier.padding(start = 8.dp)
        )
    }

    // Daftar chat
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(chatList) { chat ->
            ChatItem(chat = chat)
        }
    }
}

@Composable
fun ChatItem(chat: Chat) {
    Text(
        text = chat.title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .align(Alignment.Start)
    )

    Text(
        text = chat.sender,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .align(Alignment.End)
    )

    Text(
        text = chat.message,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .align(Alignment.Start)
    )
}

data class Chat(
    val title: String,
    val sender: String,
    val message: String,
    val timestamp: Long
)