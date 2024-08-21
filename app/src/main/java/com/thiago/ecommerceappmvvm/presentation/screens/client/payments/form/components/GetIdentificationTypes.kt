package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.ClientPaymentsFormViewModel

@Composable
fun GetIdentificationTypes(paddingValues: PaddingValues,navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {
    when(val response = vm.identificationTypeResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientPaymentsFormContent(
               paddingValues = paddingValues,
               navController=navController,
               identificationType =response.data.map {identificationType-> identificationType.id


           } )
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}