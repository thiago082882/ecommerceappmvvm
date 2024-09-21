package com.thiago.ecommerceappmvvm.presentation.screens.admin.order.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.order.AdminOrderListViewModel

@Composable
fun GetOrders(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: AdminOrderListViewModel = hiltViewModel()
) {
    when (val response = vm.ordersResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            AdminOrderListContent(paddingValues, response.data, navController)
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Ocorreu um erro desconhecido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}