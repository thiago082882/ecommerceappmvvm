package com.thiago.ecommerceappmvvm.presentation.screens.client.address.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.components.ClientAddressCreateContent
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.components.CreateAddress
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray100

@Composable
fun ClientAddressCreateScreen(navController: NavHostController, vm: ClientAddressCreateViewModel = hiltViewModel()) {

    vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Novo Endereço",
                navController = navController,
                upAvailable = true
            )
        },
        backgroundColor = Gray100
    ) {
        ClientAddressCreateContent()
    }
    CreateAddress()

}