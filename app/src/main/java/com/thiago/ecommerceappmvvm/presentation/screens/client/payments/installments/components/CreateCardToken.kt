package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun CreateCardToken(vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    when(val response = vm.cardTokenResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            vm.createPayment(response.data.id)
            Toast.makeText(LocalContext.current, "O token do cartão foi criado", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Ocorreu um erro desconhecido", Toast.LENGTH_LONG).show()
            }
        }
    }
}