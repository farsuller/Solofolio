package com.portfolio.portfoliofs.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.model.Testimonial

@Composable
fun TestimonialCard(){

    val testimonial = Testimonial.First
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box (modifier = Modifier)
        AsyncImage(
            modifier = Modifier.size(120.dp).border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(
                    topStart = 18.dp,
                    topEnd = 18.dp,
                    bottomStart = 18.dp)
            ),
            contentScale = ContentScale.Crop,
            model = "file:///android_asset/images/avatar1.png",
            contentDescription = "My Photo",
        )

        Column( modifier = Modifier
            .weight(weight = 1f)
            .padding(10.dp)) {


            Text(
                text = testimonial.fullName,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.onSurface,)
            Text(
                text = testimonial.profession,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,)


            RatingBar(modifier = Modifier.padding(top = 5.dp))

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = testimonial.review,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,)


        }
    }
}