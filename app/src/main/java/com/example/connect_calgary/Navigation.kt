package com.example.connect_calgary

import android.widget.ListView
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home

import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

/**
 * Composable to manage all the navigation in the app.
 */
@Composable
fun Navigation(attractions: MutableList<Attraction>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            Home(navController = navController)
        }
        composable(route = Screen.ListScreen.route) {
            List(navController = navController, attractionsList = attractions/*retrieveList()*/)
        }
        /*
        composable(
            route = Screen.ListScreen.route + "/{placeholder}",
            arguments = listOf(
                navArgument("placeholder") {
                    type = NavType.IntType
                    defaultValue = 1
                }
            )
        ) { entry ->
            entry.arguments?.let {
                List(
                    navController = navController,
                    attractionsList = RetrieveList()
                )
            }
        }
         */
    }

}