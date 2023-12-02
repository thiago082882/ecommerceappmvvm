package com.thiago.ecommerceappmvvm.presentation.screens.profile.update.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(vm: ProfileUpdateViewModel = hiltViewModel()) {

    when(val response = vm.updateResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            Log.d("UpdateUser", "Data: ${response.data}")
            vm.updateUserSession(response.data)
            Toast.makeText(LocalContext.current, "Os dados foram atualizados corretamente ", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Houve um erro desconhecido ", Toast.LENGTH_LONG).show()
            }
        }
    }

}