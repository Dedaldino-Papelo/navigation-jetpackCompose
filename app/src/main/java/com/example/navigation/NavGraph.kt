package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.screens.HomeScreen
import com.example.navigation.ui.screens.SignInScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signin") {
        composable("signin") {
            SignInScreen(navController = navController)
        }
        composable(
            route = "home?name={username}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            HomeScreen(
                name = navBackStackEntry.arguments?.getString("username"),
                navController = navController
            )
        }
    }
}