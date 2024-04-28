package com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientShoppingBagViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase
) : ViewModel() {

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set
    var total by mutableStateOf(0.0)
        private set

//    init {
//        getShoppingBag()
//    }

    fun getTotal() {
        total = 0.0
        shoppingBag.forEach {
            total = total + (it.price * it.quantity)
        }
    }

    fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAll().collect() {
            shoppingBag.clear()
            shoppingBag.addAll(it)
            getTotal()
        }
    }

    fun addItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        shoppingBagProduct.quantity = shoppingBagProduct.quantity + 1
        Log.d("ClientShoppingBagViewModel", "dATA: ${shoppingBagProduct}")
        shoppingBagUseCase.add(shoppingBagProduct)
        getTotal()
    }

    fun subtractItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        if (shoppingBagProduct.quantity > 1) {
            shoppingBagProduct.quantity = shoppingBagProduct.quantity - 1
            shoppingBagUseCase.add(shoppingBagProduct)
            getTotal()
        }
    }

    fun deleteItem(id: String) = viewModelScope.launch {
        shoppingBagUseCase.delete(id)
        getTotal()
    }

}