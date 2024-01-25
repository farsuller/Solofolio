package com.portfolio.portfoliofs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.portfolio.portfoliofs.components.AppTheme
import com.portfolio.portfoliofs.navigation.SetupNavGraph
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme

class MainActivity : ComponentActivity() {

    var keepSplashOpened = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { keepSplashOpened }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            var appTheme by remember { mutableStateOf(AppTheme.System) }

            MyPortfolioJCTheme(
                darkTheme = when (appTheme) {
                    AppTheme.Dark -> true
                    AppTheme.Light -> false
                    AppTheme.System -> isSystemInDarkTheme()
                },
                dynamicColor = false,
            ) {
                val navController = rememberNavController()
                SetupNavGraph(
                    startDestination = getStartDestination(),
                    navHostController = navController,
                    onDataLoaded = {
                        keepSplashOpened = false
                    },
                    darkTheme = when (appTheme) {
                        AppTheme.Dark -> true
                        AppTheme.Light -> false
                        AppTheme.System -> isSystemInDarkTheme()
                    },
                    onThemeUpdated = {
                        appTheme = when (appTheme) {
                            AppTheme.Light -> AppTheme.Dark
                            AppTheme.Dark -> AppTheme.System
                            AppTheme.System -> AppTheme.Light
                        }
                    },
                )
            }
        }
    }
}

private fun getStartDestination(): String {
    return ScreensRoutes.Home.route
}
