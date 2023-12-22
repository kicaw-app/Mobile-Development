package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryCard(
    modifier: Modifier = Modifier,
    title: String,
    photoUrl: Int
) {
Card(modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp)) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {})
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = photoUrl),
            contentDescription = "History Avatar",
            modifier = Modifier
                .padding(4.dp)
                .clip(CircleShape)
                .size(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title,
                fontWeight = FontWeight.Bold,
            )
            Text(modifier = Modifier
                .padding(4.dp),
                text = "Selasa, 11.12.2023, 20.00 pm")
        }
    }
}


}

@Preview(showBackground = true)
@Composable
fun PreviewHistory() {
    KicawCapstoneTheme {
        HistoryCard(title = "",
            photoUrl = R.drawable.blue_bird)
    }
}