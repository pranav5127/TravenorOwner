package com.pranav.travenorowner.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.pranav.travenorowner.R

@Composable
fun RequestCard(
    title: String,
    primaryIcon: Painter,
    onPrimaryClick: () -> Unit,
    secondaryIcon: ImageVector? = null,
    onSecondaryClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(36.dp)
            ) {
                IconButton(
                    onClick = onPrimaryClick,
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFF3D6DFF), CircleShape)
                ) {
                    Icon(
                        painter = primaryIcon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (secondaryIcon != null && onSecondaryClick != null) {
                    IconButton(
                        onClick = onSecondaryClick,
                        modifier = Modifier
                            .size(56.dp)
                            .background(Color(0xFF3D6DFF), CircleShape)
                    ) {
                        Icon(
                            imageVector = secondaryIcon,
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewRequestCard() {
    RequestCard(
        title = "New Request from User",
        primaryIcon = painterResource(R.drawable.tick),
        onPrimaryClick = {},
        secondaryIcon = Icons.Default.Close,
        onSecondaryClick = {}
    )
}