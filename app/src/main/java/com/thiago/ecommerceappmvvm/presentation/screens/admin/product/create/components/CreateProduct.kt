package com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.AdminProductCreateViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateProduct(vm: AdminProductCreateViewModel = hiltViewModel()) {

    when(val response = vm.productResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            vm.clearForm()
            Toast.makeText(LocalContext.current, "Los datos se han creado correctamete", Toast.LENGTH_LONG).show()
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