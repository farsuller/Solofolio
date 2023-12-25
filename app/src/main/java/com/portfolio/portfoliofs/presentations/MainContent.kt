package com.portfolio.portfoliofs.presentations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.presentations.sections.AboutMeSection

import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.PortfolioSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection


@Composable
fun MainContent(paddingValues: PaddingValues,) {
    LazyColumn(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MyIntroSection()
            Box(modifier = Modifier.fillMaxWidth().size(15.dp))
            AboutMeSection()
            Box(modifier = Modifier.fillMaxWidth().size(15.dp))
            ServiceSection()
            Box(modifier = Modifier.fillMaxWidth().size(15.dp))
            PortfolioSection()
        }



    }
}

