package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun GetInstallments(paddingValues: PaddingValues, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    when(val response = vm.installmentsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientPaymentsInstallmentsContent(paddingValues = paddingValues, installment =response.data.payerCosts )
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Houve um  erro desconhecido", Toast.LENGTH_LONG).show()
            }
        }
    }
}