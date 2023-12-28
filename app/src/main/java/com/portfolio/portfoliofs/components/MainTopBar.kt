package com.portfolio.portfoliofs.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.utils.Constants

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onThemeUpdated: () -> Unit,
    darkTheme: Boolean,
    appVersion : String
) {

    TopAppBar(
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = if (!darkTheme) R.drawable.solofolio else R.drawable.solofolio_dark),
                contentDescription = "Logo Image"
            )
        },
        title = {
            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = appVersion,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface)
        },
        actions = {
            ThemeSwitcher(
                darkTheme = darkTheme,
                size = 30.dp,
                padding = 5.dp,
                onClick = onThemeUpdated
            )
        }
    )
}