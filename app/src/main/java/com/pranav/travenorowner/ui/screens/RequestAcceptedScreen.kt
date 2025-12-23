package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pranav.travenorowner.R
import com.pranav.travenorowner.ui.components.RequestCard
import com.pranav.travenorowner.ui.components.RequestHeader

@Composable
fun RequestAcceptedScreen(
    modifier: Modifier = Modifier,
    onDone: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize()) {
            RequestHeader(title = "Success", status = "DONE")
        }

        Box(Modifier.align(Alignment.Center)) {
            RequestCard(
                title = "Accepted Successfully",
                primaryIcon = painterResource(R.drawable.tick),
                onPrimaryClick = onDone
            )
        }
    }
}
