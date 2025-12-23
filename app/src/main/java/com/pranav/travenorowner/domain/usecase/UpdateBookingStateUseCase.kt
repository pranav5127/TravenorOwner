package com.pranav.travenorowner.domain.usecase

import com.pranav.travenorowner.domain.repository.DbRepository
import com.pranav.travenorowner.ui.model.BookingState

class UpdateBookingStateUseCase(
    val repository: DbRepository
) {
    suspend operator fun invoke(id: String, state: BookingState) {
        repository.bookingState(id, state)
    }
}