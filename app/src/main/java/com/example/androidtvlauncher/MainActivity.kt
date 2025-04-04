package com.example.androidtvlauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.androidtvlauncher.ui.main.MainScreen
import com.example.androidtvlauncher.ui.pin.PinScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TVApp()
        }
    }

}

@Composable
fun TVApp(){
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){MainScreen(navController, context)}
        composable("pinScreen"){ PinScreen(navController) }
    }
}

