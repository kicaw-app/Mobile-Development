package com.satriopndt.kicawcapstone

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.component.BottomBar
import com.satriopndt.kicawcapstone.ui.history.HistoryScreen
import com.satriopndt.kicawcapstone.ui.home.HomeScreen
import com.satriopndt.kicawcapstone.ui.login.LoginScreen
import com.satriopndt.kicawcapstone.ui.signup.SignUpScreen
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
            if (Screen.useBottombar.contains(currentRoute)) {
                BottomBar(navController)
            }
        },
        floatingActionButton = {
            if (Screen.useBottombar.contains(currentRoute)) {
                FloatingActionButton(
                    onClick = {},
                    backgroundColor = colorResource(id = R.color.white)
                ) {
                    androidx.compose.material3.Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_camera_alt_24),
                        contentDescription = "Scan"
                    )
                }
            }
        },
        floatingActionButtonPosition = androidx.compose.material.FabPosition.Center,
        isFloatingActionButtonDocked = true,
        scaffoldState = scaffoldState
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route){
                LoginScreen(
                    navController = navController
                )
            }
            composable(Screen.SignUp.route){
                SignUpScreen(
                    navController = navController
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { birdId ->
                        navController.navigate(Screen.DetailBirds.createRoute(birdId))
                    },
                    navController = navController
                )
            }
            composable(Screen.History.route){
                HistoryScreen(navController = navController)
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