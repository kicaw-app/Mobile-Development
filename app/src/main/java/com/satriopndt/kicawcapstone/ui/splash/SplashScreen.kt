package com.satriopndt.kicawcapstone.ui.splash

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.navigation.Screen
import kotlinx.coroutines.delay

private const val splashDelay: Long = 3000

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    LaunchedEffect(key1 = null) {
        delay(splashDelay)
        navController.popBackStack()
        navController.navigate(Screen.Login.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
                .clip(RoundedCornerShape(10.dp))
                .rotate(360f)
                .padding(20.dp),
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "Kicaw Logo"
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Surface(color = MaterialTheme.colors.background) {
        SplashScreen(
            navController = rememberNavController()
        )
    }
}
