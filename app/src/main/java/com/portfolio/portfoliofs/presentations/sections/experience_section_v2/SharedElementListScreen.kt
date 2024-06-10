package com.portfolio.portfoliofs.presentations.sections.experience_section_v2


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Experience
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.utils.clickableWithoutRipple

@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.SharedElementListScreen(
    onItemClick: (Experience) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope
) {

    val experiences = Experience.entries.toList().reversed()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            SectionTitle(
                modifier = Modifier.fillMaxWidth(),
                section = Section.Experience,
            )
        }

        itemsIndexed(experiences) { index, exp ->

            Row(modifier = Modifier
                .fillMaxWidth()
                .clickableWithoutRipple(
                    onClick = { onItemClick(exp) },
                ))
            {

                // Define the shared element transition for the image
                AsyncImage(
                    modifier = Modifier
                        .aspectRatio(16 / 9f)
                        .weight(0.5f)
                        // Use sharedElement to specify the shared element transition
                        .sharedElement(
                            state = rememberSharedContentState(key = "image/${experiences[index].image}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            // Use boundsTransform to specify the transformation during the transition
                            boundsTransform = { _, _ ->
                                // Use tween to specify the animation behavior
                                tween(durationMillis = 500)
                            }
                        ),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(experiences[index].image)
                        .crossfade(true).build(),
                    contentDescription = null
                )

                // Define the shared element transition for the text

                Column(
                    modifier = Modifier
                        .weight(1F)
                ) {
                    Text(
                        text = exp.company,
                        modifier = Modifier
                            // Use sharedElement to specify the shared element transition
                            .sharedElement(
                                state = rememberSharedContentState(key = "text/${experiences[index].company}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                // Use boundsTransform to specify the transformation during the transition
                                boundsTransform = { _, _ ->
                                    // Use tween to specify the animation behavior
                                    tween(durationMillis = 500)
                                }
                            )
                    )

                    Text(
                        modifier = Modifier
                            // Use sharedElement to specify the shared element transition
                            .sharedElement(
                                state = rememberSharedContentState(key = "text/${experiences[index].id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                // Use boundsTransform to specify the transformation during the transition
                                boundsTransform = { _, _ ->
                                    // Use tween to specify the animation behavior
                                    tween(durationMillis = 500)
                                }
                            ),
                        text = experiences[index].jobPosition,
                        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.onSurface,
                    )

                    val to = experiences[index].to
                    val from = experiences[index].from

                    Text(
                        modifier = Modifier
                            // Use sharedElement to specify the shared element transition
                            .sharedElement(
                                state = rememberSharedContentState(key = "text/${experiences[index].from}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                // Use boundsTransform to specify the transformation during the transition
                                boundsTransform = { _, _ ->
                                    // Use tween to specify the animation behavior
                                    tween(durationMillis = 500)
                                }
                            ),
                        text = "$from - $to",
                        fontFamily = if (to == "Present") MaterialTheme.typography.titleMedium.fontFamily
                        else MaterialTheme.typography.bodyMedium.fontFamily,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }

            }
        }
    }
}

