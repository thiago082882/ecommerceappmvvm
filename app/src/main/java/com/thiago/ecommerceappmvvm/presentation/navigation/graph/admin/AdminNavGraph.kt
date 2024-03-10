package com.thiago.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin.AdminScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListScreen
import com.thiago.ecommerceappmvvm.presentation.screens.profile.info.ProfileScreen


@Composable
fun AdminNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.categoryList.route
    ) {
//        composable(route = AdminScreen.productList.route) {
//
//            AdminProductListScreen()
//
//       }
        composable(route = AdminScreen.categoryList.route) {
            AdminCategoryListScreen(navController)
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
    }
}