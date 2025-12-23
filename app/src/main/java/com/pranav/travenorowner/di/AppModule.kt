package com.pranav.travenorowner.di

import com.pranav.travenorowner.BuildConfig
import com.pranav.travenorowner.data.datasources.SupabaseDbDataSource
import com.pranav.travenorowner.data.repository.DbRepositoryImpl
import com.pranav.travenorowner.domain.repository.DbRepository
import com.pranav.travenorowner.domain.usecase.ActivateDestinationUseCase
import com.pranav.travenorowner.domain.usecase.ObserveBookingStateUseCase
import com.pranav.travenorowner.domain.usecase.UpdateBookingStateUseCase
import com.pranav.travenorowner.ui.viewmodel.BookingViewModel
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.SUPABASE_ANON_KEY
        ) {
            install(Postgrest)
            install(Realtime)
        }
    }

    single { SupabaseDbDataSource(get()) }

    single<DbRepository> { DbRepositoryImpl(get()) }

    single { ObserveBookingStateUseCase(get()) }
    single { UpdateBookingStateUseCase(get()) }
    single { ActivateDestinationUseCase(get()) }

    viewModel {
        BookingViewModel(get(), get(), get())
    }
}