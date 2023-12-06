package com.satriopndt.kicawcapstone.navigation

import android.media.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
