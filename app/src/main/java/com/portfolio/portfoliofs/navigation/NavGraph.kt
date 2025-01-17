package com.portfolio.portfoliofs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.portfolio.portfoliofs.presentations.MainScreen
import com.portfolio.portfoliofs.presentations.screens.SplashScreen

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
        startDestination = SplashRoute,
    ) {
        composable<SplashRoute> {
            SplashScreen(
                navController = navController,
                onDataLoaded = onDataLoaded,
                isUpdateAvailable = isUpdateAvailable,
            )
        }
        composable<HomeRoute> {
            MainScreen(
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated,
            )
        }
    }
}
