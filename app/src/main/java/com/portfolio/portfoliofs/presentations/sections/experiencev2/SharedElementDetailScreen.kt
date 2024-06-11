package com.portfolio.portfoliofs.presentations.sections.experiencev2

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.portfolio.portfoliofs.utils.clickableWithoutRipple

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.SharedElementDetailScreen(
    id: Int,
    companyName: String,
    companyImage: String,
    jobPosition: String,
    description: List<String>,
    from: String,
    to: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onBackPressed: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickableWithoutRipple {
                onBackPressed()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Icon(
                modifier = Modifier
                    .clickable { onBackPressed() },
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Arrow Back",
            )

            // Define the shared element transition for the image
            AsyncImage(
                modifier = Modifier
                    .aspectRatio(16 / 9f)
                    // Use sharedElement to specify the shared element transition
                    .sharedElement(
                        state = rememberSharedContentState(key = "image/$companyImage"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        // Use boundsTransform to specify the transformation during the transition
                        boundsTransform = { _, _ ->
                            // Use tween to specify the animation behavior
                            tween(durationMillis = 500)
                        },
                    ),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(companyImage)
                    .crossfade(true).build(),
                contentDescription = null,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text(
                text = companyName,
                modifier = Modifier
                    // Use sharedElement to specify the shared element transition
                    .sharedElement(
                        state = rememberSharedContentState(key = "text/$companyName"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        // Use boundsTransform to specify the transformation during the transition
                        boundsTransform = { _, _ ->
                            // Use tween to specify the animation behavior
                            tween(durationMillis = 500)
                        },
                    ),
            )

            Text(
                modifier = Modifier
                    // Use sharedElement to specify the shared element transition
                    .sharedElement(
                        state = rememberSharedContentState(key = "text/$id"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        // Use boundsTransform to specify the transformation during the transition
                        boundsTransform = { _, _ ->
                            // Use tween to specify the animation behavior
                            tween(durationMillis = 500)
                        },
                    ),
                text = jobPosition,
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                modifier = Modifier
                    // Use sharedElement to specify the shared element transition
                    .sharedElement(
                        state = rememberSharedContentState(key = "text/$from"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        // Use boundsTransform to specify the transformation during the transition
                        boundsTransform = { _, _ ->
                            // Use tween to specify the animation behavior
                            tween(durationMillis = 500)
                        },
                    ),
                text = "$from - $to",
                fontFamily = if (to == "Present") {
                    MaterialTheme.typography.titleMedium.fontFamily
                } else MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )

            description.forEach { desc ->
                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = desc,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}
