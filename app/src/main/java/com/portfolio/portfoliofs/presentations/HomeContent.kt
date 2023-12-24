package com.portfolio.portfoliofs.presentations


import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.far.suller.util.Constants
import com.far.suller.util.Constants.INTRO
import com.far.suller.util.Constants.MAIN_INTRO
import com.far.suller.util.Constants.NAME
import com.far.suller.util.Constants.ROLE
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.components.SocialBar


@Composable
fun HomeContent(paddingValues: PaddingValues,) {
    Column(
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop,
                    model = "file:///android_asset/images/main_image.png",
                    contentDescription = "My Photo",
                )

                Column( modifier = Modifier
                    .weight(weight = 1f)
                    .padding(10.dp)) {

                    Text(
                        text = INTRO,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize)
                    Text(
                        text = NAME,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize)
                    Text(
                        text = ROLE,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize)

                    SocialBar()
                }
            }

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                text = MAIN_INTRO,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }

    }
}



