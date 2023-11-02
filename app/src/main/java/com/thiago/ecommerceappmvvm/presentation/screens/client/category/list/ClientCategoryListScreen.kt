package com.thiago.ecommerceappmvvm.presentation.screens.client.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.thiago.ecommerceappmvvm.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.thiago.ecommerceappmvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ClientCategoryListScreen() {

    Scaffold {
        ClientCategoryListContent()
    }

}