package com.pranav.travenorowner.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes : NavKey {

    @Serializable
    data object PlacesScreen: Routes

    @Serializable
    data object NewRequestScreen: Routes

    @Serializable
    data object RequestAcceptedScreen: Routes

}