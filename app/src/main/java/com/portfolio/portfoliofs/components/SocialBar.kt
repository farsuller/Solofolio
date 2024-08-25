package com.portfolio.portfoliofs.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews
import com.portfolio.portfoliofs.utils.Constants

@Composable
fun SocialBar(
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
    ) {
        SocialBarItem(
            socialIcon = R.drawable.linkedin_icon,
            socialTitle = "LinkedIn",
            openUri = Constants.LINKEDIN_LINK,
        )
        SocialBarItem(
            socialIcon = R.drawable.github_icon,
            socialTitle = "Github",
            openUri = Constants.GITHUB_LINK,
        )
        SocialBarItem(
            socialIcon = R.drawable.google_play_store_icon,
            socialTitle = "Google Play Developer",
            openUri = Constants.GOOGLE_DEVELOPER_LINK,
        )
        SocialBarItem(
            socialIcon = R.drawable.facebook_icon,
            socialTitle = "Facebook Icon",
            openUri = Constants.FACEBOOK_LINK,
        )
    }
}

@Composable
fun SocialBarItem(socialIcon: Int, socialTitle: String, openUri: String) {
    val uriHandler = LocalUriHandler.current

    IconButton(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp)
            .size(25.dp),
        onClick = { uriHandler.openUri(openUri) },
    ) {
        Icon(
            modifier = Modifier
                .size(22.dp),
            painter = painterResource(id = socialIcon),
            contentDescription = socialTitle,
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }
}


@SolofolioPreviews
@Composable
private fun SocialBarPreview() {
    MyPortfolioJCTheme {
        Surface {
            SocialBar()
        }
    }
}