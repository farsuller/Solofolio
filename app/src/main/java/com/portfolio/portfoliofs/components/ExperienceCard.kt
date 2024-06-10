package com.portfolio.portfoliofs.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.portfolio.portfoliofs.model.Experience
import com.portfolio.portfoliofs.ui.theme.Elevation
import com.portfolio.portfoliofs.utils.clickableWithoutRipple
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ExperienceCard(experience: Experience) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level4,
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp),
        shape = RoundedCornerShape(13.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
        ) {

            var expanded by rememberSaveable { mutableStateOf(false) }
            AnimatedVisibility(
                remember { MutableTransitionState(false) }.apply {
                    targetState = true
                },
                enter = fadeIn(tween(durationMillis = 300)),
                exit = fadeOut(tween(durationMillis = 300)),
            ) {
                Orbital(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickableWithoutRipple(
                            onClick = { expanded = !expanded },
                        ),
                ) {
                    val showWorkDetails = rememberMovableContentOf {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .padding(horizontal = if (expanded) 20.dp else 10.dp)
                                .animateBounds(
                                    sizeAnimationSpec = tween(durationMillis = 300),
                                    positionAnimationSpec = tween(durationMillis = 300),
                                ),
                        ) {
                            Text(
                                text = experience.jobPosition,
                                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                            Text(
                                text = "${experience.from} - ${experience.to}",
                                fontFamily = if(experience.to =="Present") MaterialTheme.typography.titleMedium.fontFamily
                                else MaterialTheme.typography.bodyMedium.fontFamily,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface,
                            )

                            Text(
                                text = experience.company,
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface,
                            )

                            if (expanded) {

                                experience.description.forEach { desc->
                                    Text(
                                        modifier = Modifier.padding(top = 15.dp),
                                        text = desc,
                                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                        color = MaterialTheme.colorScheme.onSurface,
                                    )
                                }

                            } else {
                                Text(
                                    modifier = Modifier.padding(top = 10.dp),
                                    text = "See More...",
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                    color = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }
                    }

                    val showWorkLogo = rememberMovableContentOf {
                        AsyncImage(
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .animateBounds(
                                    modifier = if (expanded) {
                                        Modifier.size(300.dp)
                                    } else Modifier.size(
                                        100.dp,
                                    ),
                                ),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(experience.image)
                                .crossfade(true).build(),
                            contentDescription = "Work Logo",
                        )
                    }

                    if (expanded) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(10.dp)),
                        ) {
                            showWorkLogo()
                            showWorkDetails()
                        }
                    } else {
                        Row {
                            showWorkLogo()
                            showWorkDetails()
                        }
                    }
                }
            }
        }
    }
}
