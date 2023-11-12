package com.thiago.ecommerceappmvvm.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.profile.ProfileScreen
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.profileUpdate.route
    ){

        composable(route = ProfileScreen.profileUpdate.route){
            ProfileUpdateScreen(navController)
        }

    }
}