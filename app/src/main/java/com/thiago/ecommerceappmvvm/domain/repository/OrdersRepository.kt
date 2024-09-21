package com.thiago.ecommerceappmvvm.domain.repository

import com.thiago.ecommerceappmvvm.domain.model.Order
import com.thiago.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun findAll(): Flow<Resource<List<Order>>>

    fun findByClient(idClient :String):Flow<Resource<List<Order>>>

    suspend fun  updateStatus(id:String) : Resource<Order>
}