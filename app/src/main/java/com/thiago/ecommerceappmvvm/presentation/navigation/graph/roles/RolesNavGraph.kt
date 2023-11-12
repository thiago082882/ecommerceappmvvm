package com.thiago.ecommerceappmvvm.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.roles.RolesScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){

        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }

        composable(route = Graph.CLIENT) {
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN) {
            AdminHomeScreen()
        }
    }
}