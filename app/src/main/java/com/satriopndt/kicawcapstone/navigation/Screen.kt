package com.satriopndt.kicawcapstone.navigation

sealed class Screen(val route: String){
    object Splash: Screen("splash")
    object Login: Screen("login")
    object SignUp: Screen("signup")
    object Home: Screen("home")
    object Scan: Screen("scan")
    object Forum: Screen("forum")
    object History: Screen("history")
    object Profile: Screen("profile")
    object Discuss: Screen("discuss")
    object DetailBirds: Screen("home/{birdId}"){
        fun createRoute(birdId: Long) = "home/${birdId}"
    }

    companion object{
        val useBottombar = listOf(
            Home.route,
            Forum.route,
            Scan.route
        )
    }


}
