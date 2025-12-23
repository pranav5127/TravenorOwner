package com.pranav.travenorowner.domain.usecase

import com.pranav.travenorowner.domain.repository.DbRepository

class ActivateDestinationUseCase(
    private val repository: DbRepository
) {
    suspend operator fun invoke(id: String) {
        repository.activateDestination(id)
    }
}
