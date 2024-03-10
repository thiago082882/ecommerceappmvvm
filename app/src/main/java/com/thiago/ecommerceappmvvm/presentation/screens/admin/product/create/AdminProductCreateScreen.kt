package com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.components.CreateProduct
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray100


@Composable
fun AdminProductCreateScreen(navController: NavHostController, categoryParam: String) {

    Log.d("AdminProductListScreen", "Category: ${categoryParam}")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Novo Produto",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray100
    ) {
        AdminProductCreateContent(navController)
    }
    CreateProduct()
}