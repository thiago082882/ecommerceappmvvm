package com.thiago.ecommerceappmvvm.presentation.screens.client.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.ecommerceappmvvm.presentation.navigation.graph.client.ClientNavGraph
import com.thiago.ecommerceappmvvm.presentation.screens.client.home.components.ClientBottomBar

@Composable
fun ClientHomeScreen(navController: NavHostController= rememberNavController()) {

     Scaffold(bottomBar = { ClientBottomBar(navController = navController)}) { paddingValues->


      ClientNavGraph(navController = navController)
     }
    
}