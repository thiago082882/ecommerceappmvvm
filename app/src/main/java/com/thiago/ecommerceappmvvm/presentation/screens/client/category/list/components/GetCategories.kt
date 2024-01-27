package com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.ClientCategoryListViewModel

@Composable
fun GetCategories(
    navController: NavHostController,
    vm: ClientCategoryListViewModel = hiltViewModel()
) {

    when (val response = vm.categoriesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            ClientCategoryListContent(navController = navController, categories = response.data)
            //Log.d("getCategories" ,"data: ${response.data} ")
            // Toast.makeText(LocalContext.current, "Os dados foram atualizados corretamente", Toast.LENGTH_LONG).show()
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