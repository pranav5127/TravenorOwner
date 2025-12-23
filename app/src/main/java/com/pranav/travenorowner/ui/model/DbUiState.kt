package com.pranav.travenorowner.ui.model

sealed interface DbUiState {
    data object Initializing : DbUiState
    data object Idle : DbUiState
    data class Error(val message: String): DbUiState
}