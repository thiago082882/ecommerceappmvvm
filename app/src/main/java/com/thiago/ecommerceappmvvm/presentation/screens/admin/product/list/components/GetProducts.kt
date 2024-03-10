package com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun GetProducts(navController: NavHostController, paddingValues: PaddingValues, vm: AdminProductListViewModel = hiltViewModel()) {
    when(val response = vm.productsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           AdminProductListContent(navController = navController, products = response.data)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}