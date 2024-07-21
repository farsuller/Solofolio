package com.portfolio.portfoliofs.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.ui.theme.Elevation

@Composable
fun ServiceCard(service: Service) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.level4,
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .width(300.dp)
            .height(600.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .padding(all = 20.dp),
        ) {

            Row(modifier = Modifier.fillMaxWidth(),) {
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
                            .size(55.dp)
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
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }


            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = service.description,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}
