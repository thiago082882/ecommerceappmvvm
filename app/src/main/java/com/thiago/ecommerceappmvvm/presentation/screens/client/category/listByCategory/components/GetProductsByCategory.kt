package com.thiago.ecommerceappmvvm.presentation.screens.client.category.listByCategory.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.listByCategory.ClientProductByCategoryListViewModel

@Composable
fun GetProductsByCategory(navController: NavHostController, paddingValues: PaddingValues, vm: ClientProductByCategoryListViewModel = hiltViewModel()) {
    when(val response = vm.productsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientProductByCategoryListContent(navController = navController, paddingValues = paddingValues , products = response.data)
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