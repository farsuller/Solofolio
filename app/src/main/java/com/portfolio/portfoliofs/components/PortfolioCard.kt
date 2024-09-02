package com.portfolio.portfoliofs.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.ui.theme.Elevation
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews
import com.portfolio.portfoliofs.utils.clickableWithoutRipple

@Composable
fun PortfolioCard(portfolio: Portfolio) {
    val uriHandler = LocalUriHandler.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level4,
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .width(300.dp)
            .height(430.dp)
            .testTag("portfolioCard"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        PortfolioCardItem(portfolio = portfolio, onClick = {
            if (portfolio.link.isNotEmpty()) uriHandler.openUri(portfolio.link)
        })
    }
}

@Composable
fun PortfolioCardItem(portfolio: Portfolio, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .clickableWithoutRipple(
                onClick = { onClick() },
            ),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = portfolio.image,
                contentScale = ContentScale.Fit,
                contentDescription = portfolio.title,
                alignment = Alignment.TopCenter,
            )
        }
        Text(
            text = portfolio.title,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            text = portfolio.description,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onSurface,
        )

        if (portfolio.link.isNotEmpty()) {
            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.padding(top = 10.dp),
                text = "Click to view on Store",
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@SolofolioPreviews
@Composable
private fun PortfolioCardPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            PortfolioCard(Portfolio.entries.toTypedArray()[0])
        }
    }
}
