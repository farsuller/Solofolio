package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.far.suller.util.Constants.INTRO
import com.far.suller.util.Constants.MAIN_INTRO
import com.far.suller.util.Constants.NAME
import com.far.suller.util.Constants.ROLE
import com.portfolio.portfoliofs.components.SocialBar
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyIntroSection(){

    Column(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier.size(120.dp).clip(CircleShape),
                contentScale = ContentScale.Crop,
                model = "file:///android_asset/images/main_image.png",
                contentDescription = "My Photo",
            )

            Column( modifier = Modifier
                .weight(weight = 1f)
                .padding(10.dp)) {

                Text(
                    text = INTRO,
                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,)
                Text(
                    text = NAME,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,)
                Text(
                    text = ROLE,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,)

                SocialBar()
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()) {
            Text(
                text = MAIN_INTRO,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }

}