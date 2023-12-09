package com.satriopndt.kicawcapstone.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            HeaderBanner()

        }
    }
}

@Composable
fun HeaderBanner(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(160.dp)
                .width(400.dp)
        )
        Image(painter = painterResource(id = R.drawable.blue_bird),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .clip(CircleShape)
                .padding(30.dp),)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    KicawCapstoneTheme {
        DetailScreen()
    }
}