package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateViewModel

@Composable
fun CreateCategory(vm: AdminCategoryCreateViewModel = hiltViewModel()) {

    when(val response = vm.categoryResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
           vm.clearForm()
            Toast.makeText(LocalContext.current, "Os dados foram atualizados corretamente", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Erro desconhecido", Toast.LENGTH_LONG).show()
            }
        }
    }

}