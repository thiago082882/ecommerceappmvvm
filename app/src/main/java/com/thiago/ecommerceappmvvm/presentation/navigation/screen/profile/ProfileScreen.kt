package com.thiago.ecommerceappmvvm.presentation.navigation.screen.profile

sealed class ProfileScreen(val route : String){

    object  profileUpdate : ProfileScreen("profile/update")

}
