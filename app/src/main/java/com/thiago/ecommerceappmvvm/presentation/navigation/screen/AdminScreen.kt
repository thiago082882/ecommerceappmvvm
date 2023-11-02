package com.thiago.ecommerceappmvvm.presentation.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route : String,
    val title : String,
    val icon:ImageVector
){
    object  categoryList : AdminScreen(
        route = "admin/category/list",
        title = "categorias",
        icon = Icons.Default.List
    )
    object  productList : AdminScreen(
        route = "admin/product/list",
        title = "produtos",
        icon = Icons.Default.ThumbUp
    )
    object  Profile : AdminScreen(
        route = "admin/profile/list",
        title = "categorias",
        icon = Icons.Default.Person
    )
}
