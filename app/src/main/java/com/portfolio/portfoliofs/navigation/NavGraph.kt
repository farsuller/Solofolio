package com.portfolio.portfoliofs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.portfolio.portfoliofs.Home
import com.portfolio.portfoliofs.presentations.MainScreen

@Composable
fun SetupNavGraph(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    onDataLoaded: (Boolean) -> Unit,
    isUpdateAvailable: Boolean,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home,
    ) {
        composable<Home> {
            LaunchedEffect(key1 = Unit) {
                if (isUpdateAvailable) {
                    onDataLoaded(false)
                } else {
                    onDataLoaded(true)
                }
            }

            MainScreen(
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated,
            )
        }
    }
}
