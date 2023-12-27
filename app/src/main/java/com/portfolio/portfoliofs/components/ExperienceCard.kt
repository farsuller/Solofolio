package com.portfolio.portfoliofs.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Experience

@Composable
fun ExperienceCard(
    experience: Experience,
    sharedElement: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()


    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState)
    ) {
        sharedElement()
        AnimatedVisibility(remember { MutableTransitionState(false) }.apply { targetState = true },
            enter = fadeIn(tween(durationMillis = 600)),
            exit = fadeOut(tween(durationMillis = 600))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = experience.jobPosition,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(
                    text = "${experience.from} - ${experience.to}",
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(
                    text = experience.company,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface)

            }
        }

    }

}