package com.portfolio.portfoliofs.presentations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.navigation.HomeRoute
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    isDarkTheme: Boolean = false,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .height(262.dp)
                .fillMaxWidth(),
            painter = painterResource(
                id = if (isDarkTheme) {
                    R.drawable.solofolio_icon_v2_night
                } else R.drawable.solofolio__icon_v2_foreground,
            ),
            contentDescription = "",
        )
    }

    LaunchedEffect(Unit) {
        delay(300L)
        navController.popBackStack()
        navController.navigate(route = HomeRoute)
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    MyPortfolioJCTheme(
        darkTheme = true,
    ) {
        SplashScreen(
            navController = rememberNavController(),
            isDarkTheme = true,
        )
    }
}
