package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun ForumCard(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    time: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Use an Image to display the chat icon from a local resource
            Image(
                painter = painterResource(id = R.drawable.ic_chat), // TODO: Change this to your own icon resource
                contentDescription = "Chat Icon",
                modifier = Modifier
                    .size(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                // Use a Text to display the chat title with bold style
                Text(text = title, fontWeight = FontWeight.Bold)
                // Use a Text to display the chat message with ellipsis
                Text(text = message, modifier = Modifier.padding(4.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            // Use a Text to display the chat time with gray color
            Text(text = time)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForum() {
    KicawCapstoneTheme {
        ForumCard(
            title = "",
            message = "",
            time = ""
        )
    }
}