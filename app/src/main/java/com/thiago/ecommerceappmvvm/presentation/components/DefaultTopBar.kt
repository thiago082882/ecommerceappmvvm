package com.thiago.ecommerceappmvvm.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen


@Composable
fun DefaultTopBar(
    title : String,
    upAvailable : Boolean=false,
    navController : NavHostController? = null,
    enabledActions : Boolean=false,
) {


        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontSize = 19.sp

                )
            },
            backgroundColor = Color.White,
            navigationIcon = {
                if (upAvailable) {
                    IconButton(onClick = { navController?.popBackStack() }) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Color.Black
                        )

                    }
                }
            },
            actions = {
                if (enabledActions) {
                    IconButton(onClick = { navController?.navigate(route = ShoppingBagScreen.ShoppingBag.route) }) {

                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            tint = Color.Black
                        )

                    }
                }
            }
        )
    }

