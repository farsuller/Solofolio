package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.SkillCardV2
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Skills
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun SkillsSection() {
    val skills = Skills.entries.toTypedArray()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .testTag("skillsSection"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Skills,
            alignment = Alignment.CenterHorizontally,
        )

        SkillCardV2(skills = skills)
    }
}

@SolofolioPreviews
@Composable
private fun SkillsSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            SkillsSection()
        }
    }
}
