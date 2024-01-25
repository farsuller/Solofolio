package com.portfolio.portfoliofs

sealed class ScreensRoutes(val route: String) {

    object Home : ScreensRoutes(route = "home_screen")
    object Tabbed : ScreensRoutes(route = "tabbed_screen")
}
