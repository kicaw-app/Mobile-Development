package com.satriopndt.kicawcapstone

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.navigation.NavigationItem
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.component.BottomBar
import com.satriopndt.kicawcapstone.ui.home.HomeContent
import com.satriopndt.kicawcapstone.ui.home.HomeScreen
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun KicawApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    androidx.compose.material.Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailBirds.route) {
                BottomBar(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = colorResource(id = R.color.white)
            ) {
                androidx.compose.material3.Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_camera_alt_24),
                    contentDescription = "Scan"
                )
            }
        },
        floatingActionButtonPosition = androidx.compose.material.FabPosition.Center,
        isFloatingActionButtonDocked = true,
        scaffoldState = scaffoldState
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { birdId ->
                        navController.navigate(Screen.DetailBirds.createRoute(birdId))
                    }
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun KicawAppPreview() {
    KicawCapstoneTheme {
        KicawApp()
    }
}