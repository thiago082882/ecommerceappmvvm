package com.thiago.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ClientProductScreen

fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ) {

        composable(
            route = ClientProductScreen.ProductDetail.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {
                ClientProductDetailScreen(navController, it)
            }
        }



    }
}