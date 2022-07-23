package com.example.yyc_hacks_2022

/**
 * Helper class for Navigation.kt
 */
sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ListScreen : Screen("list_screen")
    object ReviewScreen : Screen("review_screen")
    object MapScreen : Screen("map_screen")

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
