package com.portfolio.portfoliofs

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.portfolio.portfoliofs.components.AppTheme
import com.portfolio.portfoliofs.navigation.SetupNavGraph
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme

class MainActivity : ComponentActivity() {

    private var keepSplashOpened = true
    private var isUpdateAvailable = false

    private val activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result: ActivityResult ->
            if (result.resultCode != RESULT_OK) {
                Toast.makeText(
                    this,
                    "Update Failed! Result Code:${result.resultCode}",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }

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
                Surface {
                    AppUpdateManager()

                    SetupNavGraph(
                        onDataLoaded = { splash ->
                            keepSplashOpened = !splash
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
                        isUpdateAvailable = isUpdateAvailable,
                    )
                }
            }
        }
    }

    @Composable
    private fun AppUpdateManager() {
        val appUpdateManager = AppUpdateManagerFactory.create(applicationContext)
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->

            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    activityResultLauncher,
                    AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build(),
                )
                isUpdateAvailable = true
            } else {
                isUpdateAvailable = false
            }
        }
    }
}
