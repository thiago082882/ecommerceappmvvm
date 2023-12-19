package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.components.CreateCategory
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray200

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Nova Categoria",upAvailable = true,navController=navController)
        },
        backgroundColor = Gray200
    ){

        AdminCategoryCreateContent()
    }
    CreateCategory()
}