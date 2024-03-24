package com.thiago.ecommerceappmvvm.presentation.screens.client.category.listByCategory

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.components.DeleteProduct
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.list.components.GetProducts
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.listByCategory.components.GetProductsByCategory


@Composable
fun ClientProductByCategoryListScreen(navController: NavHostController, categoryParam: String) {
    Log.d("AdminProductListScreen", "Category: ${categoryParam}")
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Produtos",
                     navController = navController,
                     upAvailable = true
                 )
        },
    ) {paddingValues ->
        GetProductsByCategory(navController = navController, paddingValues = paddingValues)
    }
}