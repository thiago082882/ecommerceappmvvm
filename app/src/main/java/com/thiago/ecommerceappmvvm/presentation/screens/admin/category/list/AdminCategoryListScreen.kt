package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list

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
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.components.DeleteCategories
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.components.GetCategories
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun AdminCategoryListScreen(navController: NavHostController) {

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = Graph.ADMIN_CATEGORY)
                },
                backgroundColor = Color.DarkGray

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.White)

            }
        }
    ) {

        GetCategories(navController = navController)
    }
    DeleteCategories()


}