package com.portfolio.portfoliofs.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Skills

@Composable
fun SkillsCard(skills: Skills) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 5.dp)
            .background(MaterialTheme.colorScheme.surface),
    ) {
        SuggestionChip(
            border = SuggestionChipDefaults.suggestionChipBorder(
                enabled = true,
                borderColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = { },
            label = {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = skills.title,
                    fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                )
            },
        )

        Text(
            text = if (skills.year == 1) "${skills.year} year" else "${skills.year} years",
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
internal fun SkillsCardPreview() {
    SkillsCard(skills = Skills.MVVM)
}
