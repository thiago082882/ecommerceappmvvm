package com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin

sealed class AdminCategoryScreen(val route : String){

    object  CategoryCreate : AdminCategoryScreen("admin/category/create")

}
