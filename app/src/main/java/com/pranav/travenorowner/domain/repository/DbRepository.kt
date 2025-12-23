package com.pranav.travenorowner.domain.repository

import com.pranav.travenorowner.data.model.Destination
import com.pranav.travenorowner.ui.model.BookingState
import kotlinx.coroutines.flow.Flow

interface DbRepository {

    fun observeBookingState(): Flow<List<Destination>>

    suspend fun bookingState(id: String, state: BookingState)

    suspend fun activateDestination(id: String)

}