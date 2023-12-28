package com.portfolio.portfoliofs.presentations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.presentations.sections.AboutMeSection
import com.portfolio.portfoliofs.presentations.sections.ContactMeSection
import com.portfolio.portfoliofs.presentations.sections.ExperienceSection
import com.portfolio.portfoliofs.presentations.sections.FooterSection
import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.PortfolioSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection
import com.portfolio.portfoliofs.presentations.sections.TestimonialSection


@Composable
fun MainContent(
    paddingValues: PaddingValues,
    lazyListState: LazyListState,
    viewModel: MainViewModel,
    darkTheme: Boolean,
    appVersion: String) {
    LazyColumn(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = lazyListState
    ) {
        item {
            MyIntroSection()
            AboutMeSection()
            ServiceSection()
            PortfolioSection()
            TestimonialSection()
            ExperienceSection()
            ContactMeSection(viewModel = viewModel)


            FooterSection(darkTheme = darkTheme, appVersion = appVersion)
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}

