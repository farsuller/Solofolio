package com.portfolio.portfoliofs.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.model.Service


@Composable
fun ServiceCard(service: Service){
    Column (
        modifier = Modifier
            .width(300.dp)
            .padding(all = 20.dp)

    )

    {
        Box (modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(
                    topStart = 18.dp,
                    topEnd = 18.dp,
                    bottomStart = 18.dp)))
        {
            Icon(
                modifier = Modifier.size(55.dp).padding(10.dp),
                painter = painterResource(id = service.icon),
                contentDescription = service.imageDesc,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = service.title,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,)

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = service.description,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.onSurface,)
    }
}