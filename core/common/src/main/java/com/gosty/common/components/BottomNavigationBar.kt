package com.gosty.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gosty.common.routes.destinations
import com.gosty.common.routes.navItem

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isVisible = destinations.contains(currentRoute)

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(durationMillis = 250)
        ),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        NavigationBar {
            navItem.forEach { screen ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = (if (currentRoute == screen.route) screen.activeIcon else screen.inactiveIcon)!!,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = screen.resourceId!!),
                            fontWeight = if (currentRoute == screen.route) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(route = screen.route) {
                            popUpTo(id = navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    alwaysShowLabel = true,
                )
            }
        }
    }
}