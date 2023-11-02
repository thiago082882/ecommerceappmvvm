package com.thiago.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.AdminScreen
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.ClientScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.ClientCategoryListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.product.list.ClientProductListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.profile.ProfileScreen


@Composable
fun AdminNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.productList.route
    ) {
        composable(route = AdminScreen.productList.route) {

            AdminProductListScreen()

        }
        composable(route = AdminScreen.categoryList.route) {
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen()
        }
    }
}