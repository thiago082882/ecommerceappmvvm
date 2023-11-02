package com.thiago.ecommerceappmvvm.presentation.screens.client.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.ecommerceappmvvm.presentation.navigation.graph.ClientNavGraph
import com.thiago.ecommerceappmvvm.presentation.screens.client.home.components.ClientBottomBar

@Composable
fun ClientHomeScreen(navController: NavHostController= rememberNavController()) {

     Scaffold(bottomBar = { ClientBottomBar(navController = navController)}) { paddingValues->


      ClientNavGraph(navController = navController)
     }
    
}