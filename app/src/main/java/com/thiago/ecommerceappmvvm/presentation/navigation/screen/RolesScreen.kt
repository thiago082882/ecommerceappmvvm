package com.thiago.ecommerceappmvvm.presentation.navigation.screen

sealed class RolesScreen(val route : String){

    object  Roles : RolesScreen("roles")

}
