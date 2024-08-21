package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.components.ClientPaymentsFormContent
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.components.GetIdentificationTypes

@Composable
fun ClientPaymentsFormScreen(
    navController: NavHostController,
    vm : ClientPaymentsFormViewModel = hiltViewModel()
) {
    vm.getIdentificationTypes()
   // vm.getInstallments(525413,12.56)

Scaffold(
   topBar = {
       DefaultTopBar(title = "Formulário de Pagamento", upAvailable = true,navController=navController)
   } 
) { paddingValues ->

    GetIdentificationTypes(paddingValues = paddingValues, navController = navController)
}
}