package com.thiago.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.ClientScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.ClientCategoryListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.product.list.ClientProductListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.profile.ProfileScreen


@Composable
fun ClientNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.productList.route
    ) {
        composable(route = ClientScreen.productList.route) {

            ClientProductListScreen()

        }
        composable(route = ClientScreen.categoryList.route) {
            ClientCategoryListScreen()
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen()
        }
    }
}