package com.thiago.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(title = "Selecione um Papel")
        }
    ){
        RolesContent(navController)
    }

}