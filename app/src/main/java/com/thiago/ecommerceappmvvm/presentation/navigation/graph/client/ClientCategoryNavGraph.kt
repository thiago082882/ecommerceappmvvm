package com.thiago.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ClientCategoryScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.listByCategory.ClientProductByCategoryListScreen

fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ) {

        composable(
            route = ClientCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                ClientProductByCategoryListScreen(navController, it)
            }
        }

//        composable(
//            route = ClientCategoryScreen.ProductDetail.route,
//            arguments = listOf(navArgument("product") {
//                type = NavType.StringType
//            })
//        ) {
//            it.arguments?.getString("product")?.let {
//                ClientProductDetailScreen(navController, it)
//            }
//        }


    }
}