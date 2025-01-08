package com.portfolio.portfoliofs.presentations.sections.serviceV2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.ServiceCard
import com.portfolio.portfoliofs.components.ServiceCardV2
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun ServiceSectionV2() {
    val services = Service.entries.toTypedArray()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .testTag("serviceSection"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Service,
        )

        LazyVerticalGrid(
            modifier = Modifier.height(200.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(services) { service ->
                ServiceCardV2(service = service)
            }
        }
    }
}

@SolofolioPreviews
@Composable
private fun ServiceSectionV2Preview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        ServiceSectionV2()
    }
}
