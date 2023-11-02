package com.thiago.ecommerceappmvvm.presentation.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController) {
    val screens = listOf(
        ClientScreen.productList,
        ClientScreen.categoryList,
        ClientScreen.Profile
    )

    val navBarEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBarEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation {
            screens.forEach { screen ->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )

            }
        }
    }

}