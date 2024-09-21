package com.thiago.ecommerceappmvvm.presentation.screens.admin.order.detail.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.order.detail.AdminOrderDetailViewModel

@Composable
fun UpdateStatusOrder(vm: AdminOrderDetailViewModel = hiltViewModel()) {
    when(val response = vm.ordersStatusResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "O pedido foi atualizado com sucesso", Toast.LENGTH_LONG).show()
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