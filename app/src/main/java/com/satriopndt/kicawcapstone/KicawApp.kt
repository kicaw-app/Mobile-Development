package com.satriopndt.kicawcapstone

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.ui.main.MainViewModel
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.component.BottomBar
import com.satriopndt.kicawcapstone.ui.detail.DetailScreen
import com.satriopndt.kicawcapstone.ui.forum.ForumScreen
import com.satriopndt.kicawcapstone.ui.history.HistoryScreen
import com.satriopndt.kicawcapstone.ui.home.HomeScreen
import com.satriopndt.kicawcapstone.ui.login.LoginScreen
import com.satriopndt.kicawcapstone.ui.scan.ScanScreen
import com.satriopndt.kicawcapstone.ui.signup.SignUpScreen
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun KicawApp(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context))
    )
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
                    onClick = { navController.navigate(Screen.Scan.route) },
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
        val session by viewModel.getSession().observeAsState()
        var destination = Screen.Login.route
        session?.let {
            if (it.isLogin) {
                destination = Screen.Home.route
            }

        }

        NavHost(
            navController = navController,
            startDestination = destination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(
                    navController = navController,
                    navigateToHome = {
                        navController.navigate(Screen.Home.route)
                    }
                )
            }
            composable(Screen.SignUp.route) {
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
            composable(Screen.History.route) {
                HistoryScreen(navController = navController)
            }
            composable(Screen.DetailBirds.route) {
                DetailScreen()
            }
            composable(Screen.Scan.route) {
                ScanScreen(navController = navController)
            }
            composable(Screen.Forum.route) {
                ForumScreen(navController = navController)
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