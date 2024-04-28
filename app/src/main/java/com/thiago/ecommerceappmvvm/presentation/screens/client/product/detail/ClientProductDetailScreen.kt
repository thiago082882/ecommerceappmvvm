package com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail.components.ClientProductDetailContent

@Composable
fun ClientProductDetailScreen(navController: NavHostController, productParam: String) {

    Scaffold() { paddingValues ->
        ClientProductDetailContent(paddingValues)
    }

}