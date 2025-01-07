package com.portfolio.portfoliofs.presentations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.presentations.sections.ContactMeSection
import com.portfolio.portfoliofs.presentations.sections.FooterSection
import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection
import com.portfolio.portfoliofs.presentations.sections.SkillsSection
import com.portfolio.portfoliofs.presentations.sections.TestimonialSection
import com.portfolio.portfoliofs.presentations.sections.experienceV2.SharedTransitionScreen
import com.portfolio.portfoliofs.presentations.sections.portfolioV2.PortfolioSectionV2

@Composable
fun MainContent(
    paddingValues: PaddingValues,
    lazyListState: LazyListState,
    darkTheme: Boolean,
    appVersion: String,
) {
    val experienceSectionClicked = remember {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = lazyListState,
    ) {
        item {
            MyIntroSection()
//            AboutMeSection()
            SkillsSection()
            //  ExperienceSection()

            Box(
                modifier = Modifier.height(if (experienceSectionClicked.value) 900.dp else 650.dp),
            ) {
                SharedTransitionScreen(
                    onItemClicked = {
                        experienceSectionClicked.value = it
                    },
                )
            }
            PortfolioSectionV2(darkTheme = darkTheme)
            ServiceSection()
            TestimonialSection()
            ContactMeSection()

            FooterSection(darkTheme = darkTheme, appVersion = appVersion)
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}
