package com.thiago.ecommerceappmvvm.presentation.screens.admin.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.ecommerceappmvvm.presentation.navigation.graph.AdminNavGraph
import com.thiago.ecommerceappmvvm.presentation.screens.admin.home.components.AdminBottomBar

@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {

     Scaffold(bottomBar={ AdminBottomBar(navController = navController)}) { paddingValues->
         AdminNavGraph(navController = navController)
     }
    
}