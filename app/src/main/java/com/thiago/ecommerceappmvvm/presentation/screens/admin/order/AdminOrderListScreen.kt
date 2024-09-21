package com.thiago.ecommerceappmvvm.presentation.screens.admin.order

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.screens.admin.order.list.components.GetOrders


@Composable
fun AdminOrderListScreen(
    navController: NavHostController,
    vm: AdminOrderListViewModel = hiltViewModel()
) {
    vm.getOrders()
    Scaffold() { paddingValues ->
        GetOrders(navController = navController, paddingValues = paddingValues)
    }

}
