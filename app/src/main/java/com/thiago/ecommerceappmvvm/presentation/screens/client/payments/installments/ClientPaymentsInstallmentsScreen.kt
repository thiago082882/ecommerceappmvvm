package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components.CreateCardToken
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components.CreatePayment
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components.GetInstallments

@Composable
fun ClientPaymentsInstallmentsScreen(navController: NavHostController, paymentFormParam: String,vm:ClientPaymentsInstallmentsViewModel= hiltViewModel()) {
    Log.d( "ClientPaymentsInstallmentsScreen ","Param:${vm.cardTokenBody}")
    Log.d( "ClientPaymentsInstallmentsScreen","Cardnumber: ${vm.cardTokenBody.cardNumber.substring(0,6).toInt()}")
vm.getInstallments(vm.cardTokenBody.cardNumber.substring(0,6).toInt(),50.0)
    Scaffold(topBar = {
        DefaultTopBar(
            title = "Número de cotas",

        )

    },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Confirmar Pagamento",
                onClick = { vm.createCardToken() }
            )
        }
    ) {paddingValues->
        GetInstallments(paddingValues = paddingValues)
    }

    CreateCardToken()
   CreatePayment(navController = navController)

}