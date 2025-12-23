package com.pranav.travenorowner.ui.model


data class UiPlace(
    val id: String,
    val name: String,
    val city: String,
    val imageUrl: String?,
    val priceText: String,
    val isActive: Boolean,
    val bookingState: BookingState
)

