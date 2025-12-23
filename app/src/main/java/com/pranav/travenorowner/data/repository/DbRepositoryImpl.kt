package com.pranav.travenorowner.data.repository

import com.pranav.travenorowner.data.datasources.SupabaseDbDataSource
import com.pranav.travenorowner.data.model.Destination
import com.pranav.travenorowner.domain.repository.DbRepository
import com.pranav.travenorowner.ui.model.BookingState
import kotlinx.coroutines.flow.Flow

class DbRepositoryImpl(
    private val dataSource: SupabaseDbDataSource
) : DbRepository {
    override fun observeBookingState(): Flow<List<Destination>> {
        return dataSource.observeBookingState()
    }

    override suspend fun bookingState(id: String, state: BookingState) {
        dataSource.updateBookingState(id, state)
    }

    override suspend fun activateDestination(id: String) {
        dataSource.setActiveDestination(id)
    }


}