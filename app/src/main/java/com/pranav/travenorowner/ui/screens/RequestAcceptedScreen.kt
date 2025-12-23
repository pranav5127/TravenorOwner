package com.pranav.travenorowner.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranav.travenorowner.ui.components.RequestCard
import com.pranav.travenorowner.ui.components.RequestHeader
import com.pranav.travenorowner.R
@Composable
fun RequestAcceptedScreen(
    modifier: Modifier = Modifier,
    onDone: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
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
                title = "Accepted Successfully",
                primaryIcon = painterResource(R.drawable.tick),
                onPrimaryClick = onDone
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewRequestAccepted() {
    RequestAcceptedScreen(
        onDone = {}
    )
}
