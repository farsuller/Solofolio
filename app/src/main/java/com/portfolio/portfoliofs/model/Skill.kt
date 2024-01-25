package com.portfolio.portfoliofs.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Skill(
    val title: String,
    val percentage: Dp,
) {
    Creative(
        title = "Creative",
        percentage = 60.dp,
    ),
    Accountable(
        title = "Accountable",
        percentage = 75.dp,
    ),
    HardWorking(
        title = "Hard Working",
        percentage = 85.dp,
    ),
    Values(
        title = "Value for Money",
        percentage = 80.dp,
    ),
    Delivery(
        title = "On Time Delivery",
        percentage = 90.dp,
    ),
}
