package com.pranav.travenorowner.ui.utils


import com.pranav.travenorowner.data.model.Destination
import com.pranav.travenorowner.ui.model.UiPlace

fun Destination.toUiPlace(): UiPlace {
    return UiPlace(
        id = id,
        name = name,
        city = city,
        imageUrl = imageUrl,
        priceText = costPerPerson?.let { "₹$it" } ?: "—",
        isActive = isActive,
        bookingState = bookingState
    )
}
