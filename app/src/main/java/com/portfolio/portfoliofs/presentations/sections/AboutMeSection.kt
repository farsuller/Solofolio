package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.portfolio.portfoliofs.utils.Constants.ABOUT_ME
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Section

@Composable
fun AboutMeSection(){

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.About)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column( modifier = Modifier.weight(weight = 1f).padding(top = 10.dp)) {
                Text(
                    text = ABOUT_ME,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface)
            }

            AsyncImage(
                modifier = Modifier.width(150.dp),
                model = "file:///android_asset/images/about_image.png",
                contentDescription = "My Photo",
            )
        }

    }
}