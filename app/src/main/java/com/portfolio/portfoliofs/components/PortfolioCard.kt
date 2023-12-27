package com.portfolio.portfoliofs.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.ui.theme.Elevation


@Composable
fun PortfolioCard(portfolio: Portfolio) {

    val uriHandler = LocalUriHandler.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level4
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .width(300.dp)
            .height(400.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    ) {

        PortfolioCardItem(portfolio = portfolio, onClick = {
            uriHandler.openUri(portfolio.link)
        })

    }


}

@Composable
fun PortfolioCardItem(portfolio: Portfolio, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .clickable { onClick() }
    )

    {
        Box(modifier = Modifier.fillMaxWidth())
        {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                model = portfolio.image,
                contentDescription = portfolio.title,
            )
        }
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = portfolio.title,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = portfolio.description,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}