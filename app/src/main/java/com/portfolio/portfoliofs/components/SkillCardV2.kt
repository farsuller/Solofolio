package com.portfolio.portfoliofs.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Skills
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews
import com.portfolio.portfoliofs.utils.Constants.DEFAULT_MAX_LINES

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun SkillCardV2(
    skills: Array<Skills>,
) {
    var maxLines by remember { mutableIntStateOf(DEFAULT_MAX_LINES) }

    ContextualFlowRow(
        modifier = Modifier
            .animateContentSize()
            .padding(8.dp)
            .testTag("skillsFlowRow"),
        itemCount = skills.size,
        maxLines = maxLines,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                TextButton(
                    onClick = { maxLines += 1 },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.surfaceVariant,
                        containerColor = MaterialTheme.colorScheme.onSurface,
                    ),
                ) {
                    Text(text = "${this@expandOrCollapseIndicator.totalItemCount - this@expandOrCollapseIndicator.shownItemCount}+ more")
                }
            },
            collapseIndicator = {
                TextButton(
                    onClick = { maxLines = DEFAULT_MAX_LINES },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                    Text(text = "Hide")
                }
            },
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) { index ->

        SuggestionChip(
            border = SuggestionChipDefaults.suggestionChipBorder(
                enabled = true,
                borderColor = MaterialTheme.colorScheme.onSurface,
            ),
            onClick = { },
            label = {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = skills[index].title,
                    fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                )
            },
        )
    }
}

@SolofolioPreviews
@Composable
private fun SkillCardV2Preview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            SkillCardV2(Skills.entries.toTypedArray())
        }
    }
}