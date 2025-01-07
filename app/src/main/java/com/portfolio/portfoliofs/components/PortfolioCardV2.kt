package com.portfolio.portfoliofs.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.ui.theme.Elevation
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews
import com.portfolio.portfoliofs.utils.clickableWithoutRipple

@Composable
fun PortfolioCardV2(portfolio: Portfolio, darkTheme: Boolean) {
    val uriHandler = LocalUriHandler.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level0,
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .testTag("portfolioCard"),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = if (darkTheme) portfolio.darkColor else portfolio.lightColor),
    ) {
        PortfolioCardItemV2(portfolio = portfolio, onClick = {
            if (portfolio.link.isNotEmpty()) uriHandler.openUri(portfolio.link)
        })
    }
}

@Composable
fun PortfolioCardItemV2(portfolio: Portfolio, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        if (portfolio.link.isNotEmpty()) {
            Icon(
                modifier = Modifier
                    .padding(top = 5.dp, end = 5.dp)
                    .align(Alignment.TopEnd)
                    .size(25.dp),
                painter = painterResource(R.drawable.link_icon),
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = null,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 10.dp, bottom = 10.dp)
                .clickableWithoutRipple(
                    onClick = { onClick() },
                ),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .weight(0.4F),
                model = portfolio.image,
                contentScale = ContentScale.Fit,
                contentDescription = portfolio.title,
                alignment = Alignment.TopCenter,
            )
            Column(
                Modifier.weight(1F),
            ) {
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
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 18.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
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
            PortfolioCardV2(Portfolio.entries.first(), darkTheme = false)
        }
    }
}
