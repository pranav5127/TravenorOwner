package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pranav.travenorowner.ui.components.PlaceCard
import com.pranav.travenorowner.ui.components.SearchBar
import com.pranav.travenorowner.ui.model.DbUiState
import com.pranav.travenorowner.ui.viewmodel.BookingViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PlacesScreen(
    modifier: Modifier = Modifier,
    onPlaceClick: (String) -> Unit,
    viewModel: BookingViewModel = koinViewModel()
) {
    val places by viewModel.places.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    var query by remember { mutableStateOf("") }

    val filtered = places.filter {
        it.name.contains(query, true) || it.city.contains(query, true)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        Spacer(Modifier.height(12.dp))

        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Search",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(Modifier.height(20.dp))

        SearchBar(
            value = query,
            onValueChange = { query = it }
        )

        Spacer(Modifier.height(24.dp))

        when (uiState) {
            DbUiState.Initializing -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is DbUiState.Error -> {
                Text(
                    text = (uiState as DbUiState.Error).message
                )
            }

            DbUiState.Idle -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(filtered) { place ->
                        PlaceCard(
                            title = place.name,
                            location = place.city,
                            price = place.priceText,
                            imageUrl = place.imageUrl,
                            onCardClick = {
                                onPlaceClick(place.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
