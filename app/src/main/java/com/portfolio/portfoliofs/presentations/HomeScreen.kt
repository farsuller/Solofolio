package com.portfolio.portfoliofs.presentations

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.components.ThemeSwitcher
import com.portfolio.portfoliofs.utils.getAppVersion


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun HomeScreen(
    onMenuClicked: () -> Unit,
    drawerState: DrawerState,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
) {
    var padding by remember { mutableStateOf(PaddingValues()) }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val appVersion = getAppVersion(LocalContext.current)
    NavigationDrawer(
        drawerState = drawerState,
        darkTheme = darkTheme,
        onThemeUpdated = onThemeUpdated,
        appVersion = appVersion
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                HomeTopBar(
                    onMenuClicked = onMenuClicked,
                    scrollBehavior = scrollBehavior)
            },
            floatingActionButton = {},
            content = {
                padding = it
                HomeContent(paddingValues = it)
            }
        )
    }
}

@Composable
internal fun NavigationDrawer(
    drawerState: DrawerState,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    appVersion: String,
    content: @Composable () -> Unit,
) {

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(200.dp),
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier.size(200.dp),
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo Image"
                            )
                            Text(
                                text = appVersion,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                    Column (modifier = Modifier.fillMaxWidth()){
                        NavigationDrawerItem(
                            label = {
                                Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                                    Icon(
                                        imageVector = Icons.Default.Settings,
                                        contentDescription = "Settings Icon",
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "Settings",
                                        color = MaterialTheme.colorScheme.onSurface)

                                }
                            },
                            selected = false,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        NavigationDrawerItem(
                            label = {
                                ThemeSwitcher(
                                    darkTheme = darkTheme,
                                    size = 50.dp,
                                    padding = 5.dp,
                                    onClick = onThemeUpdated
                                )
                            },
                            selected = false,
                            onClick = {}
                        )
                    }


                }
            )
        },
        content = content
    )
}

@Composable
fun AppVersion() {
    val appVersion = getAppVersion(LocalContext.current)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = appVersion,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppVersionPreview() {
    AppVersion()
}