package com.pranav.travenorowner.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.pranav.travenorowner.ui.model.BookingState
import com.pranav.travenorowner.ui.screens.NewRequestScreen
import com.pranav.travenorowner.ui.screens.PlacesScreen
import com.pranav.travenorowner.ui.screens.RequestAcceptedScreen
import com.pranav.travenorowner.ui.viewmodel.BookingViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationRoot(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier,
    viewModel: BookingViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.navigateToRequest.collect {
            if (backStack.lastOrNull() !is Routes.NewRequestScreen) {
                backStack.add(Routes.NewRequestScreen)
            }
        }
    }

    val selectedPlace by viewModel.selectedPlace.collectAsState()

    Scaffold { innerPadding ->
        NavDisplay(
            backStack = backStack,
            entryProvider = { route ->
                when (route) {

                    is Routes.PlacesScreen -> NavEntry(route) {
                        PlacesScreen(
                            modifier = modifier.padding(innerPadding),
                            onPlaceClick = { id ->
                                viewModel.selectPlace(id)
                                backStack.add(Routes.NewRequestScreen)
                            }
                        )
                    }

                    is Routes.NewRequestScreen -> NavEntry(route) {
                        when (selectedPlace?.bookingState) {

                            BookingState.ACCEPTED -> {
                                RequestAcceptedScreen(
                                    modifier = modifier.padding(innerPadding),
                                    onDone = {
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }

                            else -> {
                                NewRequestScreen(
                                    modifier = modifier.padding(innerPadding),
                                    place = selectedPlace,
                                    onAccept = {
                                        selectedPlace?.let {
                                            viewModel.accept(it.id)
                                        }
                                    },
                                    onReject = {
                                        viewModel.reject(selectedPlace!!.id)
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }
                        }
                    }

                    else -> error("Unknown route")
                }
            }
        )
    }
}
