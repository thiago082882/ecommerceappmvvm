package com.thiago.ecommerceappmvvm.presentation.screens.profile.info

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold {
        ProfileContent(navController = navController )
    }

}