package com.thiago.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.component.LoginContent
import com.thiago.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme


@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(
        content = { paddingValues ->
            LoginContent(navController =navController, paddingValues)
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {

    EcommerceAppMVVMTheme {
        LoginScreen(rememberNavController())
    }
}