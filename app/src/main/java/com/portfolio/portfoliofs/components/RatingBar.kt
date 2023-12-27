package com.portfolio.portfoliofs.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.far.suller.util.Res
import com.portfolio.portfoliofs.R


@Composable
fun RatingBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        repeat(5) {
            Icon(
                modifier = Modifier
                    .padding(2.dp)
                    .size(14.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "Star Icon"
            )
        }
    }
}