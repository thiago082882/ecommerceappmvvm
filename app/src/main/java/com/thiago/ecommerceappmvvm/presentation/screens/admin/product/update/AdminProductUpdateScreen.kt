package com.thiago.ecommerceappmvvm.presentation.screens.admin.product.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.update.components.UpdateProduct
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray200

@Composable
fun AdminProductUpdateScreen(navController: NavHostController, productParam: String) {

    Log.d(
        "com.thiago.ecommerceappmvvm.presentation.screens.admin.product.update.AdminProductUpdateScreen",
        "Category: ${productParam}"
    )
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Atualizar produto",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) { paddingValues ->
        AdminProductUpdateContent(paddingValues = paddingValues)
    }
    UpdateProduct()
}