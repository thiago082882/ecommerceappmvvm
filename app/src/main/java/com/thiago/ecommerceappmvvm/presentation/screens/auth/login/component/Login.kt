package com.thiago.ecommerceappmvvm.presentation.screens.auth.login.component

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when (val response = vm.loginResponse) {
        Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if(response.data.user?.roles!!.size > 1){
                            navController.navigate(route = Graph.ROLES) {
                                popUpTo(Graph.AUTH) {
                                    inclusive = true
                                }
                            }
                }else {
                    navController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.AUTH){
                            inclusive=true
                        }
                    }
                }

            }
        }
        is Resource.Failure ->{
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {

            if (response != null) {
                Toast.makeText(LocalContext.current, "Erro desconhecido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}