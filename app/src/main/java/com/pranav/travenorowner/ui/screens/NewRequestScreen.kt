package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pranav.travenorowner.R
import com.pranav.travenorowner.ui.components.RequestCard
import com.pranav.travenorowner.ui.components.RequestHeader
import com.pranav.travenorowner.ui.model.BookingState
import com.pranav.travenorowner.ui.model.UiPlace

@Composable
fun NewRequestScreen(
    modifier: Modifier = Modifier,
    place: UiPlace?,
    onAccept: () -> Unit,
    onReject: () -> Unit
) {
    if (place == null) return

    Box(modifier = modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize()) {
            RequestHeader(
                title = place.name,
                status = "Active Now"
            )
        }

        Box(Modifier.align(Alignment.Center)) {
            when (place.bookingState) {

                BookingState.IDLE -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                        Text(
                            text = "Waiting for booking request…",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                BookingState.REQUEST -> {
                    RequestCard(
                        title = "New Request from User",
                        primaryIcon = painterResource(R.drawable.tick),
                        onPrimaryClick = onAccept,
                        secondaryIcon = Icons.Default.Close,
                        onSecondaryClick = onReject
                    )
                }

                else -> Unit
            }
        }
    }
}
