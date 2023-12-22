package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.Shapes

@Composable
fun BirdItem(
    photoUrl: Int,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.clickable { onClick.invoke() }) {
        Image(
            painter = painterResource(photoUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(Shapes.medium)
        )
        Text(
            text = name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun BirdItemPreview(){
    KicawCapstoneTheme {
        BirdItem(R.drawable.blue_bird, "Blue Bird", onClick = {})
    }
}