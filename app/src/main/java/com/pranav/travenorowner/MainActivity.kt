package com.pranav.travenorowner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pranav.travenorowner.ui.screens.PlacesScreen
import com.pranav.travenorowner.ui.theme.TravenorOwnerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravenorOwnerTheme {
                PlacesScreen()
            }
        }
    }
}
