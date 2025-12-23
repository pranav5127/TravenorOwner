package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pranav.travenorowner.R
import com.pranav.travenorowner.ui.components.PlaceCard
import com.pranav.travenorowner.ui.components.SearchBar

@Composable
fun PlacesScreen(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit = {},
    onCardClick: () -> Unit
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp)
    ) {

        Spacer(Modifier.height(12.dp))

        // Top bar
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Search",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )

            Text(
                text = "Cancel",
                color = Color(0xFF2979FF),
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable { onCancel() }
            )
        }

        Spacer(Modifier.height(20.dp))

        SearchBar(
            value = query,
            onValueChange = { query = it }
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "Search Places",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                PlaceCard(
                    title = "Kolkata Reservoir",
                    location = "Kolkata, India",
                    price = "$894",
                    imageRes = R.drawable.img_1,
                    onCardClick = onCardClick

                )
            }

            item {
                PlaceCard(
                    title = "Bombay Tirtugas",
                    location = "Bombay, India",
                    price = "$894",
                    imageRes = R.drawable.img_2,
                    onCardClick = onCardClick

                )
            }

            item {
                PlaceCard(
                    title = "Bombay Tirtugas",
                    location = "Bombay, India",
                    price = "$894",
                    imageRes = R.drawable.img_2,
                    onCardClick = onCardClick
                )
            }
            item {
                PlaceCard(
                    title = "Bombay Tirtugas",
                    location = "Bombay, India",
                    price = "$894",
                    imageRes = R.drawable.img_2,
                    onCardClick = onCardClick
                )
            }
            item {
                PlaceCard(
                    title = "Bombay Tirtugas",
                    location = "Bombay, India",
                    price = "$894",
                    imageRes = R.drawable.img_2,
                    onCardClick = onCardClick
                )
            }
            item {
                PlaceCard(
                    title = "Bombay Tirtugas",
                    location = "Bombay, India",
                    price = "$894",
                    imageRes = R.drawable.img_2,
                    onCardClick = onCardClick
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlacesScreen() {
    PlacesScreen(onCardClick = {})
}