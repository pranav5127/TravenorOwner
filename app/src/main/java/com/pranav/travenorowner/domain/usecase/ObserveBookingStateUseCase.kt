package com.pranav.travenorowner.domain.usecase

import com.pranav.travenorowner.data.model.Destination
import com.pranav.travenorowner.domain.repository.DbRepository
import kotlinx.coroutines.flow.Flow

class ObserveBookingStateUseCase(
    private val repository: DbRepository
) {
    operator fun invoke(): Flow<List<Destination>> {
        return repository.observeBookingState()

    }
}