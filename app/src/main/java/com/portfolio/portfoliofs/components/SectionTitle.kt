package com.portfolio.portfoliofs.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Section


@Composable
fun sectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
){
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.dp) }
    var subTitleMargin by remember { mutableStateOf(50.dp) }


    Column(
        modifier = modifier,
        horizontalAlignment = alignment)
    {
        Text(section.title)
        Text(section.subtitle)


    }
}