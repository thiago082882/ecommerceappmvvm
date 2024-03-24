package com.thiago.ecommerceappmvvm.presentation.screens.client.product.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.Product
import com.thiago.ecommerceappmvvm.domain.useCase.products.ProductsUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(private val productsUseCase: ProductsUseCase): ViewModel() {

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    var search by mutableStateOf("")


    init {
        getProducts()
    }
    fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findAll().collect() {
            Log.d("ClientProductListViewModel", "Data: $it")
            productsResponse = it
        }
    }

    fun getProductsByName(name: String) = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findByName(name).collect() {
            Log.d("ClientProductListViewModel", "Data: $it")
            productsResponse = it
        }
    }

    fun onSearchInput(value: String) {
        search = value
    }

}