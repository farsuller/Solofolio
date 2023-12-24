package com.portfolio.portfoliofs



sealed class ScreensRoutes(val route: String) {

    object Home : ScreensRoutes(route = "home_screen")

}
