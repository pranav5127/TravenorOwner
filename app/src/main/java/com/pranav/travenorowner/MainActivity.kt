package com.pranav.travenorowner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.pranav.travenorowner.ui.navigation.NavigationRoot
import com.pranav.travenorowner.ui.navigation.Routes
import com.pranav.travenorowner.ui.theme.TravenorOwnerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val startDestination: NavKey = Routes.PlacesScreen
            val backStack = rememberNavBackStack(startDestination)
            TravenorOwnerTheme {
                NavigationRoot(backStack = backStack)
            }
        }
    }
}
