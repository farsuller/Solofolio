package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.SkillCardV2
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Skills

@Composable
fun SkillsSection() {
    val skills = Skills.entries.toTypedArray()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp),
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

@Preview
@Composable
internal fun SkillsCardPreview() {
    SkillsSection()
}
