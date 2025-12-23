package com.pranav.travenorowner.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pranav.travenorowner.domain.usecase.ObserveBookingStateUseCase
import com.pranav.travenorowner.domain.usecase.ActivateDestinationUseCase
import com.pranav.travenorowner.domain.usecase.UpdateBookingStateUseCase
import com.pranav.travenorowner.ui.model.BookingState
import com.pranav.travenorowner.ui.model.DbUiState
import com.pranav.travenorowner.ui.model.UiPlace
import com.pranav.travenorowner.ui.utils.toUiPlace
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BookingViewModel(
    observeBookingStateUseCase: ObserveBookingStateUseCase,
    private val activateDestinationUseCase: ActivateDestinationUseCase,
    private val updateBookingStateUseCase: UpdateBookingStateUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DbUiState>(DbUiState.Initializing)
    val uiState: StateFlow<DbUiState> = _uiState.asStateFlow()

    private val _selectedPlaceId = MutableStateFlow<String?>(null)

    private val _navigateToRequest = MutableSharedFlow<Unit>(
        replay = 0,
        extraBufferCapacity = 1
    )
    val navigateToRequest = _navigateToRequest.asSharedFlow()

    val places: StateFlow<List<UiPlace>> =
        observeBookingStateUseCase()
            .map { list -> list.map { it.toUiPlace() } }
            .onEach { list ->
                _uiState.value = DbUiState.Idle

                val selectedId = _selectedPlaceId.value
                val selected = list.firstOrNull { it.id == selectedId }

                if (selected?.bookingState == BookingState.REQUEST) {
                    _navigateToRequest.tryEmit(Unit)
                }
            }
            .catch { e ->
                _uiState.value = DbUiState.Error(
                    e.message ?: "Something went wrong"
                )
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )

    val selectedPlace: StateFlow<UiPlace?> =
        combine(places, _selectedPlaceId) { list, id ->
            list.firstOrNull { it.id == id }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            null
        )

    fun selectPlace(id: String) {
        _selectedPlaceId.value = id
        viewModelScope.launch {
            activateDestinationUseCase(id)
        }
    }

    fun accept(id: String) {
        viewModelScope.launch {
            updateBookingStateUseCase(id, BookingState.ACCEPTED)
        }
    }

    fun reject(id: String) {
        viewModelScope.launch {
            updateBookingStateUseCase(id, BookingState.CANCELED)
        }
    }
}
