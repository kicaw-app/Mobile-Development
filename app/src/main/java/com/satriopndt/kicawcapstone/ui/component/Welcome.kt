package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun Welcome(
    modifier: Modifier = Modifier
){
   Box(modifier = modifier
       .padding(16.dp)){
       Image(painter = painterResource(R.drawable.gliter_sky),
           modifier = Modifier.height(129.dp)
               .fillMaxWidth()
               .clip(RoundedCornerShape(15.dp)),
           contentDescription = "Banner Welcome",
           contentScale = ContentScale.Crop,

       )
       Row(
           modifier = Modifier
               .padding(top = 24.dp)
               .fillMaxWidth(1f),
           horizontalArrangement = Arrangement.Center,
       ) {
           Text(
               text = stringResource(id = R.string.welcome_banner),
               fontWeight = FontWeight.ExtraBold
           )
       }

   }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview(){
    KicawCapstoneTheme {
        Welcome()
    }
}