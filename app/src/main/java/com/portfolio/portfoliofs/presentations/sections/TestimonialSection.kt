package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.PagerButtons
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.TestimonialCard
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Testimonial
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun TestimonialSection() {
    val pagerState = rememberPagerState(initialPage = 0) { Testimonial.entries.size }
    val testimonial = Testimonial.entries.toTypedArray()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Testimonial,
        )

        HorizontalPager(state = pagerState) { page ->
            TestimonialCard(testimonial = testimonial[page])
        }

        PagerButtons(pagerState = pagerState, pageCount = testimonial.size)
    }
}

@SolofolioPreviews
@Composable
private fun TestimonialSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        TestimonialSection()
    }
}
