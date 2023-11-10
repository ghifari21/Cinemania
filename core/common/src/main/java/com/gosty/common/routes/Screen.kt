package com.gosty.common.routes

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.gosty.common.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int? = null,
    val activeIcon: ImageVector? = null,
    val inactiveIcon: ImageVector? = null
) {
    object Home : Screen(
        route = "home",
        resourceId = R.string.home,
        activeIcon = Icons.Filled.Home,
        inactiveIcon = Icons.Outlined.Home
    )

    object Explore : Screen(
        route = "explore",
        resourceId = R.string.explore,
        activeIcon = Icons.Filled.Explore,
        inactiveIcon = Icons.Outlined.Explore
    )

    object Favorite : Screen(
        route = "favorite",
        resourceId = R.string.favorite,
        activeIcon = Icons.Filled.Favorite,
        inactiveIcon = Icons.Outlined.FavoriteBorder
    )
}
