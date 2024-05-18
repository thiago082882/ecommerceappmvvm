package com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.ClientAddressListViewModel

@Composable
fun GetAddress(vm: ClientAddressListViewModel = hiltViewModel()) {
    when (val response = vm.addressResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            ClientAddressListContent(response.data)
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}