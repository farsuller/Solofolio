package com.portfolio.portfoliofs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.portfolio.portfoliofs.ScreensRoutes
import com.portfolio.portfoliofs.presentations.MainScreen
import com.portfolio.portfoliofs.presentations.MainViewModel
import com.portfolio.portfoliofs.presentations.TabbedMainScreen

@Composable
fun SetupNavGraph(
    startDestination: String,
    navHostController: NavHostController,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    onDataLoaded: () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination)
    {
        homeRoute(
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,
            onDataLoaded = onDataLoaded)
    }
}

fun NavGraphBuilder.homeRoute(
    darkTheme: Boolean,
    onDataLoaded: () -> Unit,
    onThemeUpdated: () -> Unit) {
    composable(route = ScreensRoutes.Home.route) {

         val mainViewModel: MainViewModel = viewModel()

        LaunchedEffect(key1 = true) {
            onDataLoaded()
        }

        MainScreen(
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,
            viewModel = mainViewModel)
    }
}

fun NavGraphBuilder.tabbedScreenRoute() {
    composable(route = ScreensRoutes.Tabbed.route) {
        TabbedMainScreen()

    }
}