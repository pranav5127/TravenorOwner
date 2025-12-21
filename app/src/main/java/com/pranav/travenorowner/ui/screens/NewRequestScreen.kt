package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranav.travenorowner.ui.components.RequestCard
import com.pranav.travenorowner.ui.components.RequestHeader
import com.pranav.travenorowner.R
@Composable
fun NewRequestScreen(
    onAccept: () -> Unit,
    onReject: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            RequestHeader()
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            RequestCard(
                title = "New Request from User",
                primaryIcon = painterResource(R.drawable.tick),
                onPrimaryClick = onAccept,
                secondaryIcon = Icons.Default.Close,
                onSecondaryClick = onReject
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewRequest() {
    NewRequestScreen({}, {})
}

