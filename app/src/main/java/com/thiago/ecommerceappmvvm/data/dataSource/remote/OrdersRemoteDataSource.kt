package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.domain.model.Order
import retrofit2.Response

interface OrdersRemoteDataSource {


    suspend fun findAll(): Response<List<Order>>


    suspend fun findByClient(idClient:String): Response<List<Order>>


    suspend fun updateStatus(id:String): Response<Order>


}