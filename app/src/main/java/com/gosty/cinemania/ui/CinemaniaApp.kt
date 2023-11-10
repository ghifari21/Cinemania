package com.gosty.cinemania.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gosty.common.components.BottomNavigationBar

@Composable
fun CinemaniaApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        CinemaniaNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}