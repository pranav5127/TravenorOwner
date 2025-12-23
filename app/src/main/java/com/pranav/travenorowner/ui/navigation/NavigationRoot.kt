package com.pranav.travenorowner.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.pranav.travenorowner.ui.screens.NewRequestScreen
import com.pranav.travenorowner.ui.screens.PlacesScreen
import com.pranav.travenorowner.ui.screens.RequestAcceptedScreen

@Composable
fun NavigationRoot(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = { route ->
                when(route) {
                    is Routes.PlacesScreen -> NavEntry(route) {
                        PlacesScreen(
                            modifier = modifier.padding(innerPadding),
                            onCardClick = {
                                backStack.add(Routes.NewRequestScreen)
                            }
                        )
                    }
                    is Routes.NewRequestScreen -> NavEntry(route) {
                        NewRequestScreen(
                            modifier = modifier.padding(innerPadding),
                            onAccept = {},
                            onReject = {}
                        )
                    }
                    is Routes.RequestAcceptedScreen -> NavEntry(route) {
                        RequestAcceptedScreen(
                            modifier = modifier.padding(innerPadding),
                            onDone = {}
                        )
                    }
                    else -> throw IllegalArgumentException("Invalid route: $route")
                }

            }
        )

    }
}