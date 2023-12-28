package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.utils.Constants.ABOUT_ME
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.SocialBar
import com.portfolio.portfoliofs.model.Section

@Composable
fun FooterSection(darkTheme: Boolean, appVersion : String){

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                modifier = Modifier.height(50.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = if (!darkTheme) R.drawable.solofolio else R.drawable.solofolio_dark),
                contentDescription = "Logo Image"
            )
            Text(
                text = appVersion,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface)

            SocialBar(horizontalArrangement = Arrangement.Center)

            Spacer(modifier = Modifier.height(28.dp))
        }
}