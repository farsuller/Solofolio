package com.portfolio.portfoliofs.presentations

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.AppTheme
import com.portfolio.portfoliofs.components.MainTopBar
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.utils.getAppVersion
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    var padding by remember { mutableStateOf(PaddingValues()) }
    val lazyListState by remember { mutableStateOf(LazyListState()) }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val appVersion = getAppVersion(LocalContext.current)

    val showButton by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemScrollOffset > 0
        }
    }
    var rotY by remember { mutableFloatStateOf(180f) }

    val animatedRotationY by animateFloatAsState(
        targetValue = rotY,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessVeryLow,
        ),
        label = "RotationY Animation",
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MainTopBar(
                scrollBehavior = scrollBehavior,
                appVersion = appVersion,
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated,
            )
        },
        floatingActionButton = {
            if (showButton) {
                FloatingActionButton(
                    modifier = Modifier.rotate(degrees = animatedRotationY),
                    onClick = {
                        scope.launch {
                            lazyListState.animateScrollToItem(index = 0)
                        }
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Default.ArrowUpward,
                            contentDescription = "Scroll to Top",
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                    },
                )
            }

            LaunchedEffect(showButton) {
                rotY = if (showButton) {
                    0f
                } else {
                    180f
                }
            }
        },
        content = {
            padding = it
            MainContent(
                paddingValues = it,
                lazyListState = lazyListState,
                darkTheme = darkTheme,
                appVersion = appVersion,
            )
        },
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = appVersion,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    var appTheme by remember { mutableStateOf(AppTheme.System) }
    MyPortfolioJCTheme {
        MainScreen(
            darkTheme = false,
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
