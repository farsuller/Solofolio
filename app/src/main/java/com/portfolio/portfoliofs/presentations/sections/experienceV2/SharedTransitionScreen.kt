package com.portfolio.portfoliofs.presentations.sections.experienceV2

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.portfolio.portfoliofs.utils.canBackStack

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScreen(onItemClicked: (Boolean) -> Unit) {
    // Layout for shared element transitions
    SharedTransitionLayout {
        val navController = rememberNavController()

        // Define a flag to indicate whether animation is in progress
        var isAnimating by remember { mutableStateOf(false) }

        NavHost(navController = navController, startDestination = ListScreen) {
            // Destination for the list screen
            composable<ListScreen> {
                SharedElementListScreen(
                    onItemClick = { experience ->
                        // Navigate to the detail screen when an item is clicked
                        if (!isAnimating) {
                            isAnimating = true

                            navController.navigate(
                                DetailScreen(
                                    id = experience.id,
                                    companyImage = experience.image,
                                    companyName = experience.company,
                                    jobPosition = experience.jobPosition,
                                    description = experience.description,
                                    from = experience.from,
                                    to = experience.to,
                                ),
                            )
                        }
                        onItemClicked(true)
                    },
                    animatedVisibilityScope = this,
                )
            }

            // Destination for the detail screen
            composable<DetailScreen> {
                val args = it.toRoute<DetailScreen>()
                // Extract arguments passed from the list screen

                SharedElementDetailScreen(
                    id = args.id,
                    companyName = args.companyName,
                    companyImage = args.companyImage,
                    jobPosition = args.jobPosition,
                    description = args.description,
                    from = args.from,
                    to = args.to,
                    onBackPressed = {
                        if (navController.canBackStack) {
                            isAnimating = false
                            navController.popBackStack()
                            onItemClicked(false)
                        }
                    },
                    animatedVisibilityScope = this,
                )

                // Handle back press events
                HandleBackPress {
                    isAnimating = false // Reset the isAnimating flag

                    if (navController.canBackStack) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}

@Composable
fun HandleBackPress(
    onBackPressed: () -> Unit,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed() // Execute the provided onBackPressed function
            }
        }
    }
    DisposableEffect(backCallback) {
        onBackPressedDispatcher?.addCallback(backCallback)
        onDispose {
            backCallback.remove() // Remove the callback when the effect is disposed
        }
    }
}
