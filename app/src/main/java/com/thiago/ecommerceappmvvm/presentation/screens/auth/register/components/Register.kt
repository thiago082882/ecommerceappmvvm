package com.thiago.ecommerceappmvvm.presentation.screens.auth.register.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.components.ProgressBar
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.thiago.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {

    when(val response = vm.registerResponse) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = Graph.CLIENT) {
                    popUpTo(Graph.AUTH) {
                        inclusive = true
                    }
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconhecido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}