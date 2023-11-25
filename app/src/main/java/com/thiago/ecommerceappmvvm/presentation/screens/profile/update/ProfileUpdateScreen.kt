package com.thiago.ecommerceappmvvm.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.components.ProfileUpdateContent

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam : String) {

    Log.d( "ProfileUpdateScreen","Data: $userParam")
    Scaffold(topBar = { DefaultTopBar(title = "Atualizar perfil",navController=navController, upAvailable = true)}) {
        ProfileUpdateContent()
    }

}