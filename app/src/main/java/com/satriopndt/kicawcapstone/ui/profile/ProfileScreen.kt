package com.satriopndt.kicawcapstone.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    // Menggunakan gambar dari resource drawable
    val profileImage = imageResource(id = R.drawable.profile_picture)
    // Membuat layout kolom
    Column(modifier = Modifier.padding(16.dp)) {
        // Menampilkan gambar dengan bentuk lingkaran
        Image(
            bitmap = profileImage.asImageBitmap(),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .padding(8.dp)
                .size(128.dp)
                .clip(CircleShape)
        )
        // Membuat kartu dengan teks nama dan email
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Satrio Pinandito",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "codez@gmail.com",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}
