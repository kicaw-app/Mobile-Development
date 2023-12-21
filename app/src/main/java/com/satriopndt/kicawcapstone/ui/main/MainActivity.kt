package com.satriopndt.kicawcapstone.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.satriopndt.kicawcapstone.KicawApp
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            KicawCapstoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KicawApp()
                    setContent {
                        KicawCapstoneTheme {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                KicawApp()
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun LinearGradient(){
//    val gradient = Brush.linearGradient(
//        0.0 to Color.Blue,
//        500.0f to Color.White,
//        start = Offset.Zero,
//        end = Offset.Infinite
//    )
//}
