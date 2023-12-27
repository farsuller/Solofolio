package com.portfolio.portfoliofs.presentations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.portfolio.portfoliofs.presentations.sections.AboutMeSection
import com.portfolio.portfoliofs.presentations.sections.ExperienceSection
import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.PortfolioSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection
import com.portfolio.portfoliofs.presentations.sections.TestimonialSection


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
            AboutMeSection()
            ServiceSection()
            PortfolioSection()
            TestimonialSection()
            ExperienceSection()
        }



    }
}

