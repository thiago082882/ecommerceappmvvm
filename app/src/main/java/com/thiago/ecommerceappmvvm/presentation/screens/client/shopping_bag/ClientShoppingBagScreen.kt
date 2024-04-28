package com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar

@Composable
fun ClientShoppingBagScreen(
    navController: NavHostController,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {

    vm.getShoppingBag()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Meu Pedido",
                upAvailable = true,
                navController = navController
            )
        },
        bottomBar = {
            ClientShoppingBagBottomBar(navController)
        }

    ) { paddingValues ->
        ClientShoppingBagContent(paddingValues, vm.shoppingBag)
    }
}