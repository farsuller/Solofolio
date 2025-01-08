package com.portfolio.portfoliofs.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.ui.theme.Elevation
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun ServiceCardV2(service: Service) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = Elevation.level1),
        modifier = Modifier
            .width(300.dp)
            .padding(all = 5.dp)
            .testTag("serviceCard"),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        Row(modifier = Modifier.padding(top = 20.dp, end = 10.dp, start = 10.dp, bottom = 20.dp).fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = RoundedCornerShape(
                            topStart = 18.dp,
                            topEnd = 18.dp,
                            bottomStart = 18.dp,
                        ),
                    ),
            ) {
                Icon(
                    modifier = Modifier
                        .size(45.dp)
                        .padding(10.dp),
                    painter = painterResource(id = service.icon),
                    contentDescription = service.imageDesc,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
            Text(
                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                text = service.title,
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 15.sp
            )
        }
    }
}

@SolofolioPreviews
@Composable
private fun ServiceCardPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            ServiceCardV2(Service.entries.toTypedArray()[0])
        }
    }
}
