package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.ServiceCard
import com.portfolio.portfoliofs.components.SkillsCard
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Service
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                content = {
                    items(skills) { skill ->
                        SkillsCard(skills = skill)
                    }
                },
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}
@Preview
@Composable
internal fun SkillsCardPreview() {
    SkillsSection()
}