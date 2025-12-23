package com.pranav.travenorowner.data.datasources

import com.pranav.travenorowner.data.model.Destination
import com.pranav.travenorowner.ui.model.BookingState
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseExperimental
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.realtime.selectAsFlow
import kotlinx.coroutines.flow.Flow

class SupabaseDbDataSource(
    private val supabase: SupabaseClient
) {
    @OptIn(SupabaseExperimental::class)
    fun observeBookingState(): Flow<List<Destination>> {
        return supabase
            .from(table = "locations")
            .selectAsFlow(
               primaryKey = Destination::id,
            )
    }

    suspend fun setActiveDestination(id: String) {
        supabase
            .from(table = "locations")
            .update(update = {
                set("is_active", true)
            }) {
                filter {
                    eq(column = "id", value = id)
                }
            }
    }

    suspend fun updateBookingState(
        id: String,
        state: BookingState
    ) {
       supabase
           .from(table = "locations")
           .update(
                update = {
                   set("booking_state", state.name)
               }
           ) {
               filter {
                   eq(column ="id", value = id)
               }
           }
    }
}