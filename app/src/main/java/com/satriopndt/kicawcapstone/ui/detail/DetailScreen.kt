 package com.satriopndt.kicawcapstone.ui.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.BlueLight
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.Neutral8
import com.satriopndt.kicawcapstone.ui.theme.PurpleGrey80
import com.satriopndt.kicawcapstone.ui.theme.blueGreen
import com.satriopndt.kicawcapstone.ui.theme.toskaLight

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            HeaderBanner()
            CardDetail(
                title = "Nuri",
                type = "Blue Bird",
                price = 1500000,
                description = stringResource(id = R.string.loremIpsum),
                maintenance = "bird care"
            )

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
        Image(
            painter = painterResource(id = R.drawable.blue_bird),
            contentDescription = null,
            modifier = Modifier
                .size(270.dp)
                .clip(CircleShape)
                .rotate(360f),
            contentScale = ContentScale.Crop,

            )
    }

}

@Composable
fun CardDetail(
    modifier: Modifier = Modifier,
    title: String,
    type: String,
    price: Int,
    description: String,
    maintenance: String
) {
    var showFullText by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier.animateContentSize()
            .padding(12.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = BlueLight
        )
    ) {
        Column {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = type,
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = stringResource(id = R.string.priceBird, price),
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .clickable {
                        showFullText != showFullText
                    },
                text = description,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = if (showFullText) 100 else 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    KicawCapstoneTheme {
        CardDetail(
            title = "Nuri",
            type = "Blue Bird",
            price = 1500000,
            description = stringResource(id = R.string.loremIpsum),
            maintenance = "bird care"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    KicawCapstoneTheme {
        DetailScreen()
    }
}