package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun AdminCategoryListScreen() {

    Scaffold {
        AdminCategoryListContent()
    }

}