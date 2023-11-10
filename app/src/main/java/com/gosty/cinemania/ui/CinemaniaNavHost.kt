package com.gosty.cinemania.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gosty.common.routes.Screen
import com.gosty.explore.ExploreScreen
import com.gosty.explore.ExploreViewModel
import com.gosty.favorite.FavoriteScreen
import com.gosty.favorite.FavoriteViewModel
import com.gosty.home.screens.HomeScreen
import com.gosty.home.screens.HomeViewModel

@Composable
fun CinemaniaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(viewModel = viewModel)
        }

        composable(Screen.Explore.route) {
            val viewModel: ExploreViewModel = hiltViewModel()
            ExploreScreen(viewModel = viewModel)
        }

        composable(Screen.Favorite.route) {
            val viewModel: FavoriteViewModel = hiltViewModel()
            FavoriteScreen(viewModel = viewModel)
        }
    }
}