package com.portfolio.portfoliofs.presentations.sections

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Experience
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.ui.theme.Elevation
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.animateSharedElementTransition
import com.skydoves.orbital.rememberContentWithOrbitalScope
import com.skydoves.orbital.rememberMovableContentOf

@Composable
fun ExperienceSection() {

    val experience = Experience.entries.toTypedArray()
    var isTransformed by rememberSaveable { mutableStateOf(false) }

//    val sharedImage = rememberContentWithOrbitalScope {
//        AsyncImage(
//            modifier = if (isTransformed) {
//                Modifier
//                    .fillMaxWidth()
//                    .height(500.dp)
//            } else {
//                Modifier
//                    .size(width = 130.dp, height = 220.dp)
//                    .clip(shape = RoundedCornerShape(size = 10.dp))
//            }.animateSharedElementTransition(
//                orbitalScope = this,
//                movementSpec = SpringSpec(stiffness = 500f),
//                transformSpec = SpringSpec(stiffness = 500f)
//            ),
//            model = ImageRequest.Builder(LocalContext.current).data(experience)
//                .crossfade(true).build(),
//            contentDescription = "Work Logo",
//            contentScale = ContentScale.Crop
//        )
//    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Experience,
            alignment = Alignment.CenterHorizontally
        )

        Orbital(
            // modifier = Modifier.clickable { isTransformed = !isTransformed }
        ) {
//            if(isTransformed){
//                ExperienceCard(
//                    experience = experience,
//                    sharedElement = {sharedImage()}
//                )
//            }
//            else{
//                Column(modifier = Modifier.fillMaxSize().padding(20.dp),
//                    horizontalAlignment = Alignment.End,
//                    verticalArrangement = Arrangement.Bottom) {
//                    sharedImage()
//                }
//            }
            ExperienceCardList(experience = experience)


        }
    }
}

@Composable
fun ExperienceCardList(experience: Array<Experience>) {
    Column {
        repeat(experience.size) { expDetails ->
            ExperienceCardItem(index = expDetails)
        }
    }
}

@Composable
fun ExperienceCardItem(index: Int) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level4),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp),
        shape = RoundedCornerShape(13.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)){

        Column(modifier = Modifier.fillMaxSize().padding(all= 10.dp)) {

            val experience = Experience.entries.toTypedArray()
            var expanded by rememberSaveable { mutableStateOf(false) }
            AnimatedVisibility(remember { MutableTransitionState(false) }.apply {
                targetState = true
            },
                enter = fadeIn(tween(durationMillis = 300)),
                exit = fadeOut(tween(durationMillis = 300))
            ) {
                Orbital(modifier = Modifier
                    .fillMaxWidth()
                    .clickableWithoutRipple(
                        interactionSource = MutableInteractionSource(),
                        onClick = { expanded = !expanded }
                    )
                ) {
                    val showWorkDetails = rememberMovableContentOf {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .padding(horizontal = if (expanded) 20.dp else 10.dp)
                                .animateBounds(
                                    sizeAnimationSpec = tween(durationMillis = 300),
                                    positionAnimationSpec = tween(durationMillis = 300)
                                )
                        ) {

                            Text(
                                text = experience[index].jobPosition,
                                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${experience[index].from} - ${experience[index].to}",
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface)

                            Text(
                                text = experience[index].company,
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = MaterialTheme.colorScheme.onSurface
                            )


                            if (expanded) {
                                Text(
                                    modifier = Modifier.padding(top = 15.dp),
                                    text = experience[index].description,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            else{
                                Text(
                                    modifier = Modifier.padding(top = 10.dp),
                                    text = "See More...",
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }

                    val showWorkLogo = rememberMovableContentOf {
                        AsyncImage(
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .animateBounds(
                                    modifier = if (expanded) Modifier.fillMaxWidth() else Modifier.size(100.dp)
                                ),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(experience[index].image)
                                .crossfade(true).build(),
                            contentDescription = "Work Logo"
                        )
                    }

                    if (expanded) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(10.dp))
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

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            )
        )
    }
)