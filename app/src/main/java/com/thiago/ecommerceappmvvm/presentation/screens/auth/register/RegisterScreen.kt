package com.thiago.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.LoginScreen
import com.thiago.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterContent
import com.thiago.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme

@Composable
fun RegisterScreen(navController: NavHostController) {

    Scaffold(

        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ) {
     RegisterContent()

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {

    EcommerceAppMVVMTheme {
        RegisterScreen(rememberNavController())
    }
}