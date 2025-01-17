package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.PortfolioCard
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun PortfolioSection() {
    val portfolio = Portfolio.entries.toTypedArray().take(11)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .testTag("portfolioSection"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Portfolio,
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            LazyRow {
                items(portfolio) { portfolioEntry ->
                    PortfolioCard(portfolioEntry)
                }
            }
        }
    }
}

@SolofolioPreviews
@Composable
private fun PortfolioSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        PortfolioSection()
    }
}
