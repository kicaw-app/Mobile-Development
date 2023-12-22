package com.satriopndt.kicawcapstone.ui.profile

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satriopndt.kicawcapstone.R
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.ui.history.HistoryScreen
import com.satriopndt.kicawcapstone.ui.history.HistoryViewModel
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground

@Composable
fun ProfileScreen(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Membuat layout kolom
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(blueBackground)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(270.dp)
                .clip(CircleShape)
                .rotate(360f),
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(45.dp))
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(293.dp)
                .height(330.dp)
                .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp)),
            elevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Satrio Pinandito",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "codez@gmail.com",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    KicawCapstoneTheme {
        ProfileScreen(navController = rememberNavController())
    }
}