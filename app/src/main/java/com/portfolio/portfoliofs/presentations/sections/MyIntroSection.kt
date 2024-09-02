package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.components.SocialBar
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews
import com.portfolio.portfoliofs.utils.Constants.INTRO
import com.portfolio.portfoliofs.utils.Constants.MAIN_INTRO
import com.portfolio.portfoliofs.utils.Constants.NAME
import com.portfolio.portfoliofs.utils.Constants.ROLE
import com.portfolio.portfoliofs.utils.Res

@Composable
fun MyIntroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .testTag("introSection"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                model = Res.Image.MAIN_IMAGE_INTRO,
                contentDescription = "My Photo",
            )

            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(10.dp)
                    .testTag("introText"),
            ) {
                Text(
                    text = INTRO,
                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = NAME,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = ROLE,
                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 20.sp,
                )

                SocialBar()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = MAIN_INTRO,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@SolofolioPreviews
@Composable
private fun MyIntroSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        MyIntroSection()
    }
}
