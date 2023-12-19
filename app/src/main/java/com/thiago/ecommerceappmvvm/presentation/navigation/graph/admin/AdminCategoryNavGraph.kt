package com.thiago.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.roles.RolesScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){

        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }


    }
}