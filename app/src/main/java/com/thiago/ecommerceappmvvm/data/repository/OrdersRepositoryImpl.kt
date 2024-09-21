package com.thiago.ecommerceappmvvm.data.repository

import com.thiago.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
import com.thiago.ecommerceappmvvm.domain.model.Order
import com.thiago.ecommerceappmvvm.domain.repository.OrdersRepository
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrdersRepositoryImpl(
    private val ordersRemoteDataSource: OrdersRemoteDataSource
):OrdersRepository {
    override fun findAll(): Flow<Resource<List<Order>>> = flow{
        emit(ResponseToRequest.send(ordersRemoteDataSource.findAll()))
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(ordersRemoteDataSource.findByClient(idClient)))
    }

    override suspend fun updateStatus(id: String): Resource<Order> = ResponseToRequest.send(
        ordersRemoteDataSource.updateStatus(id)
    )


}