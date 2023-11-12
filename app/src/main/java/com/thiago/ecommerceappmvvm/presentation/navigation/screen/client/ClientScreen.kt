package com.thiago.ecommerceappmvvm.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route : String,
    val title : String,
    val icon:ImageVector
){
    object  categoryList : ClientScreen(
        route = "client/category/list",
        title = "categorias",
        icon = Icons.Default.List
    )
    object  productList : ClientScreen(
        route = "client/product/list",
        title = "produtos",
        icon = Icons.Default.ThumbUp
    )
    object  Profile : ClientScreen(
        route = "client/profile",
        title = "perfil",
        icon = Icons.Default.Person
    )
    object  ProfileUpdate : ClientScreen(
        route = "client/profile/update",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
