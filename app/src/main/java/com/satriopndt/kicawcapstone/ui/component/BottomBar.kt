package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.navigation.NavigationItem
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.home_screen),
            icon = ImageVector.vectorResource(R.drawable.ic_home_),
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.forum_screen),
            icon = ImageVector.vectorResource(R.drawable.ic_chat),
            screen = Screen.Forum
        ),
    )
    androidx.compose.material.BottomAppBar(
        cutoutShape = CircleShape,
        contentColor = Color.White,
        backgroundColor = colorResource(id = R.color.white)
    ) {
        navigationItems.forEachIndexed { index, navigationItem ->
            if (index == 1) {
                NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = { /*TODO*/ })
            }
            NavigationBarItem(
                selected = (currentRoute == navigationItem.screen.route),
                onClick = { navController.navigate(navigationItem.screen.route) },
                icon = {
                    Icon(
                        imageVector = navigationItem.icon,
                        contentDescription = navigationItem.title,
                        tint = Color.Gray
                    );
                },
                enabled = true
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview(navController: NavHostController = rememberNavController()){
    KicawCapstoneTheme {
        BottomBar(navController)
    }
}
