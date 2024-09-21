package com.thiago.ecommerceappmvvm.presentation.screens.admin.order

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.Order
import com.thiago.ecommerceappmvvm.domain.useCase.orders.OrdersUseCases
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderListViewModel @Inject  constructor(private val useCases: OrdersUseCases):ViewModel() {
var ordersResponse by mutableStateOf<Resource<List<Order>>?>(null)
    var ordersByClientResponse  by mutableStateOf<Resource<List<Order>>?>(null)
    var ordersStatusResponse  by mutableStateOf<Resource<Order>?>(null)


    fun getOrders()= viewModelScope.launch {
        useCases.findAllOrdersUseCase().collect(){
            ordersResponse = it
            Log.d("AdminOrderListViewModel","Data Orders: $ordersResponse" )
        }
    }
    fun getOrdersByClient(idClient:String)= viewModelScope.launch {
        useCases.findByClientOrdersUseCase(idClient).collect(){
            ordersResponse = it
            Log.d("AdminOrderListViewModel","Data Orders by Client: $ordersByClientResponse" )
        }
    }
    fun updateStatus(id:String)= viewModelScope.launch {
        ordersStatusResponse = Resource.Loading
        val result = useCases.updateStatusOrdersUseCase(id)
            ordersStatusResponse= result
            Log.d("AdminOrderListViewModel","Data  Update Orders: $ordersStatusResponse" )
        }
    }
