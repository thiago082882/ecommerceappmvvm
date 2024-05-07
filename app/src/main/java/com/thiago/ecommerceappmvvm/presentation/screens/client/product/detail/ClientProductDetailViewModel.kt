package com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.Product
import com.thiago.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingBagUseCase: ShoppingBagUseCase
) : ViewModel() {

    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImages = listOf<String>(product.image1 ?: "", product.image2 ?: "")

    var quantity by mutableStateOf(0)
        private set

    var price by mutableStateOf(0.0)
        private set

    init {
        getShoppingBagProduct()
    }

    fun add()  {
        quantity = quantity + 1
        price = product.price * quantity
    }

    fun remove()  {
        if (quantity > 0) {
            quantity = quantity - 1
            price = product.price * quantity
        }
    }

    fun getShoppingBagProduct() = viewModelScope.launch {

        val result = shoppingBagUseCase.findById(product.id ?: "")
        quantity = result?.quantity ?: 0
        price = product.price * quantity

    }

    fun saveItem() = viewModelScope.launch {
        Log.d("ClientProductDetailViewModel", "Id: ${product.id}")
        if (quantity > 0) {
            val shoppingBagProduct = ShoppingBagProduct(
                id = product.id ?: "",
                name = product.name,
                price = product.price,
                image1 = product.image1 ?: "",
                idCategory = product.idCategory,
                quantity = quantity
            )
           shoppingBagUseCase.add(shoppingBagProduct)
        }
    }

}