package com.thiago.ecommerceappmvvm.presentation.screens.client.order.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.order.detail.components.UpdateStatusOrder
import com.thiago.ecommerceappmvvm.presentation.screens.client.order.detail.components.ClientOrderDetailContent

@Composable
fun ClientOrderDetailScreen(
    navController: NavHostController,
    orderParam: String,
    vm: ClientOrderDetailViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detalhe do pedido",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        ClientOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()

}