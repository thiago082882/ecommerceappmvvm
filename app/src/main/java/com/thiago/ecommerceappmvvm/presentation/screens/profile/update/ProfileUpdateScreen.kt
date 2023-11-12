package com.thiago.ecommerceappmvvm.presentation.screens.profile.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.components.ProfileUpdateContent

@Composable
fun ProfileUpdateScreen(navController: NavHostController) {

    Scaffold(topBar = { DefaultTopBar(title = "Atualizar perfil",navController=navController, upAvailable = true)}) {
        ProfileUpdateContent()
    }

}