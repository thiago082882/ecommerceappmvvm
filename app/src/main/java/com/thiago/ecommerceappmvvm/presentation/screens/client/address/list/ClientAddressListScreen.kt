package com.thiago.ecommerceappmvvm.presentation.screens.client.address.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.components.GetAddress

@Composable
fun ClientAddressListScreen(navController: NavHostController, vm: ClientAddressListViewModel = hiltViewModel()) {

    vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Meus Endereços",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 10.dp),
                onClick = {
                    navController.navigate(route = ShoppingBagScreen.AddressCreate.route)
                },
                backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp).fillMaxWidth(),
                text = "Continuar",
                onClick = { navController.navigate(route = ShoppingBagScreen.PaymentsForm.route) }
            )
        }
    ) { paddingValues ->
        GetAddress()
    }

}