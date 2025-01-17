package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.ExperienceCard
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Experience
import com.portfolio.portfoliofs.model.Section

@Composable
fun ExperienceSection() {
    val experience = Experience.entries.toTypedArray()

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
            section = Section.Experience,
            alignment = Alignment.CenterHorizontally,
        )

        ExperienceCardList(experience = experience)
    }
}

@Composable
fun ExperienceCardList(experience: Array<Experience>) {
    Column {
        experience.reversed().forEach { expDetails ->
            ExperienceCard(experience = expDetails)
        }
    }
}
