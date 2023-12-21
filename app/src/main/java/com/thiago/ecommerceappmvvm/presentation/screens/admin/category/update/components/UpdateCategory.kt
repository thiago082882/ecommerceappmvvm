package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.update.AdminCategoryUpdateViewModel

@Composable
fun UpdateCategory(vm: AdminCategoryUpdateViewModel = hiltViewModel(), vmList: AdminCategoryListViewModel = hiltViewModel()) {

    when(val response = vm.categoryResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vmList.getCategories()
            }

//            when(val response = vmList.categoriesResponse) {
//                Resource.Loading -> {
//                    ProgressBar()
//                }
//                is Resource.Success -> {
////                    response.data.tr
//                }
//                is Resource.Failure -> {
//                    Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
//                }
//                else -> {
//                    if (response != null) {
//                        Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
//                    }
//                }
//            }

            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamete", Toast.LENGTH_LONG).show()
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