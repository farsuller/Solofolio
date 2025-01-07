package com.portfolio.portfoliofs.presentations.sections.portfolioV2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.PortfolioCardV2
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun PortfolioSectionV2(darkTheme: Boolean = false) {
    val portfolio = Portfolio.entries.toTypedArray().take(8)
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

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            portfolio.forEach { entry ->
                PortfolioCardV2(portfolio = entry, darkTheme = darkTheme)
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
        PortfolioSectionV2()
    }
}
