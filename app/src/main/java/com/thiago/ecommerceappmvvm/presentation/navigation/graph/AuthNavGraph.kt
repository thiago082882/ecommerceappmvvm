package com.thiago.ecommerceappmvvm.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.LoginScreen
import com.thiago.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen
import com.thiago.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }

    }
}