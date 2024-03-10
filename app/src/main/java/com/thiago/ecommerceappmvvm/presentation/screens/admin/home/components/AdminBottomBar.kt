package com.thiago.ecommerceappmvvm.presentation.screens.admin.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController) {
    val screens = listOf(
       // AdminScreen.productList,
        AdminScreen.categoryList,
        AdminScreen.Profile
    )

    val navBarEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBarEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation {
            screens.forEach { screen ->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )

            }
        }
    }

}