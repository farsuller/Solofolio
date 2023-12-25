package com.portfolio.portfoliofs.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.portfolio.portfoliofs.ScreensRoutes
import com.portfolio.portfoliofs.presentations.MainScreen
import kotlinx.coroutines.launch

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
            onDataLoaded = onDataLoaded
        )

    }
}

fun NavGraphBuilder.homeRoute(
    darkTheme: Boolean,
    onDataLoaded: () -> Unit,
    onThemeUpdated: () -> Unit
) {
    composable(route = ScreensRoutes.Home.route) {

        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        LaunchedEffect(key1 = true) {
            onDataLoaded()
        }

        MainScreen(

            drawerState = drawerState,
            onMenuClicked = {
                scope.launch {
                    drawerState.open()
                }
            },
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,

            )

    }
}