package com.portfolio.portfoliofs.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Service


@Composable
fun PortfolioCard(portfolio: Portfolio){
    Column (
        modifier = Modifier.width(300.dp).padding(all = 20.dp))

    {
        Box (modifier = Modifier)
        {
            AsyncImage(
                modifier = Modifier.size(220.dp),
                model = portfolio.image,
                contentDescription = portfolio.title,
            )

        }
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = portfolio.title,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,)

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = portfolio.description,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,)
    }
}