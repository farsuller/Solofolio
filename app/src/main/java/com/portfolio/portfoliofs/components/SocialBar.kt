package com.portfolio.portfoliofs.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.utils.Constants


@Composable
fun SocialBar(
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement
        ){
        SocialBarItem (socialIcon = R.drawable.facebook_icon, socialTitle = "Facebook Icon", openUri = Constants.FACEBOOK_LINK)
        SocialBarItem (socialIcon = R.drawable.instagram_icon, socialTitle = "Instagram Icon", openUri = Constants.INSTAGRAM_LINK)
        SocialBarItem (socialIcon = R.drawable.twitter_icon, socialTitle = "Twitter Icon", openUri = Constants.TWITTER_LINK)
        SocialBarItem (socialIcon = R.drawable.linkedin_icon, socialTitle = "LinkedIn Icon", openUri = Constants.LINKEDIN_LINK)
    }
}

@Composable
fun SocialBarItem (socialIcon : Int, socialTitle : String, openUri : String){

    val uriHandler = LocalUriHandler.current

    IconButton(
        modifier = Modifier.padding(top = 10.dp).size(25.dp),
        onClick = { uriHandler.openUri(openUri) }) {
        Icon(modifier = Modifier
            .size(22.dp),
            painter = painterResource(id = socialIcon),
            contentDescription = socialTitle,
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}
