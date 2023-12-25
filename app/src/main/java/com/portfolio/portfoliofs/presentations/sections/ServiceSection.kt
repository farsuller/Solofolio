package com.portfolio.portfoliofs.presentations.sections

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.far.suller.util.Constants.INTRO
import com.far.suller.util.Constants.MAIN_INTRO
import com.far.suller.util.Constants.NAME
import com.far.suller.util.Constants.ROLE
import com.portfolio.portfoliofs.components.SocialBar
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.far.suller.util.Constants.ABOUT_ME
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.components.ServiceCard
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.model.Service

@Composable
fun ServiceSection(){
    val services = Service.entries.toTypedArray()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Service,
            alignment = Alignment.CenterHorizontally)

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(650.dp)
        ) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),

            ) {
                items(services) {
                    ServiceCard(service = it)
                }


            }
        }




    }
}