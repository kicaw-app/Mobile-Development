package com.satriopndt.kicawcapstone.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
<<<<<<< HEAD:app/src/main/java/com/satriopndt/kicawcapstone/ui/main/MainActivity.kt
import com.satriopndt.kicawcapstone.KicawApp
=======
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satriopndt.kicawcapstone.ui.splash.SplashScreen
>>>>>>> 16144b9a8a7273e3c80c1b784a81c17574c9eb49:app/src/main/java/com/satriopndt/kicawcapstone/MainActivity.kt
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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
<<<<<<< HEAD:app/src/main/java/com/satriopndt/kicawcapstone/ui/main/MainActivity.kt
                    KicawApp()

=======
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
>>>>>>> 16144b9a8a7273e3c80c1b784a81c17574c9eb49:app/src/main/java/com/satriopndt/kicawcapstone/MainActivity.kt
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
